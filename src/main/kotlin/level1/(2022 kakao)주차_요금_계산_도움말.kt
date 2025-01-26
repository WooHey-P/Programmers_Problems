package level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * */
data class CarFees(
    val type: String,
    var fee: Int
)

private fun solution(fees: IntArray, records: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()

    // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
    val initTime = fees[0]
    val initFee = fees[1]
    val unitTime = fees[2]
    val unitFee = fees[3]

    val v1 = records
        .map { it.split(" ") }
        .groupBy { it[1] }
        .map { it.value }
        .run {
            map {
                // it -> 각 차량별, 각 요소별
            }
        }.toList()

    val carList = records
        .map { it.split(" ") }  // 각 요소로 나눠서 map 으로
        .groupBy { it[1] }      // 차량 번호별로 묶음
        .asSequence()
        .map { it.value }
        .toMutableList()
        .run {
            map {  }
        }


        return answer
}

private fun main() {
    val fees1 = intArrayOf(180, 5000, 10, 600)
    val records1 = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")

    val fees2 = intArrayOf(120, 0, 60, 591)
    val records2 = arrayOf("16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN")

    solution(fees1, records1).forEach { print("$it, ") }
    println()

    solution(fees2, records2).forEach { print("$it, ") }
    println()
}