package level1

class 대충만든자판 {
    fun 대충만든자판(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        targets.map { target ->
            var sum = 0

            var notFound = false
            target.map { t ->
                if (notFound) {
                    return@map
                }
                var minIdx = 101
                // 최소 위치의 문자열 찾기
                keymap.forEach { key ->
                    val idx = key.indexOf(t)
                    if (idx != -1 && idx < minIdx) {
                        minIdx = idx
                    }
                }
                if (minIdx == 101) {
                    notFound = true
                    sum = -1
                } else {
                    sum += minIdx + 1
                }
            }

            if (sum != 0) {
                answer += sum
            }
        }

        return answer
    }
}

fun main() {
    val v1 = 대충만든자판().대충만든자판(arrayOf("ABACD", "BCEFD"),arrayOf("ABCD","AABB"))
    val v2 = 대충만든자판().대충만든자판(arrayOf("AGZ"),arrayOf("YGZ", "BSSS"))
    println(v1.contentToString())
}