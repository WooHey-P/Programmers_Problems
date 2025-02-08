package level2

class 호텔대실 {

    fun 호텔대실1(book_time: Array<Array<String>>): Int {
        val times = book_time
            .map { (start, end) ->
                val inTime = start.toIdx()
                val outTime = end.toIdx() + 10 // 퇴실 후 10분 청소 시간 추가
                Pair(inTime, outTime)
            }
            // 입실 시간 기준 정렬
            .sortedBy { it.first }

        val pq = java.util.PriorityQueue<Int>()

        for ((inTime, outTime) in times) {
            // 가장 빨리 퇴실하는 방을 확인하여, 퇴실 후 청소가 끝난 방에 새로운 예약을 할당
            if (pq.isNotEmpty() && pq.peek() <= inTime) {
                pq.poll() // 퇴실한 방을 제거
            }
            pq.offer(outTime) // 새 예약을 처리할 방에 추가
        }

        // 최소 객실 수는 큐에 남은 방의 개수
        return pq.size
    }

    fun 호텔대실(book_time: Array<Array<String>>): Int {
        var answer: Int = 0

        // 10분 단위로..
        // 0, 1, 2, ... 9, 10,
        // 15:20 ~ 15:40 -> 920 ~ 940 -> arr[92] ~ arr[94] 까지 채우기
        // 방 하나당 00:00 ~ 23:50 -> arr[0] ~ arr[143]

        // 최대 길이 143 인 string arr
        var rooms = mutableListOf<String>()

        book_time
            // 입실, 퇴실, 머무는시간
            .map { in_out ->
                val (inTime, outTime) = in_out.map{ it.toIdx() }
                // 92, 94, 2
                Triple(inTime, outTime, outTime - inTime)
            }
            // 머무는 시간 기준 내림차순
            .sortedByDescending{ it.third }
            .map { (inTime, outTime, len) ->
                var found = false

                rooms.forEach { room ->
                    // 방이 비었을 경우, 방에 넣기
                    if (room.slice(inTime..outTime).none{ it == '*' } ) {
                        room.replaceRange(inTime, outTime, "*")
                        found = true
                        return@forEach
                    }
                }

                // 방 못 찾았을 때
                if (!found) {
                    var newRoom = "-".repeat(143)
                        .replaceRange(inTime, outTime, "*".repeat(len))
                    rooms.add(newRoom)

                }
            }

        return rooms.size
    }

    fun String.toIdx() = this.split(":").let{ (it[0].toInt() * 60 + it[1].toInt()) / 10 }
}

fun main() {
    println(호텔대실().호텔대실(arrayOf(
        arrayOf("15:00", "17:00"),
        arrayOf("16:40", "18:20"),
        arrayOf("14:20", "15:20"),
        arrayOf("14:10", "19:20"),
        arrayOf("18:20", "21:20")
    )))
}