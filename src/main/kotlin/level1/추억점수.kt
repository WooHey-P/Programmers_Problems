package level1

/**
 * @param name 그리워하는 사람 이름 목록
 * @param yearning 그리움 점수 목록
 * @param photo 각 사진에 찍힌 인물 이름 목록
 */
private fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    val map = name.zip(yearning.toTypedArray()).toMap()
    return photo.map { pt -> pt.sumOf { map[it] ?: 0 }}.toIntArray()
}

private fun main() {
    val v1 = solution(
        name = arrayOf("may", "kein", "kain", "radi"),
        yearning = intArrayOf(5, 10, 1, 3),
        photo = arrayOf(
            arrayOf("may", "kein", "kain", "radi"),
            arrayOf("may", "kein", "brin", "deny"),
            arrayOf("kon", "kain", "may", "coni")
        )
    )

    println(v1.map { it.toString() })
}