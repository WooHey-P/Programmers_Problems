

private fun solution(n: Int, recent: Int, recently_use: Int, total_use: Int, records: Array<IntArray>): IntArray {
    val allApps = (1..n)
    val group = records.groupBy({it[1]}, { Pair(it[0], it[2]) })

    return allApps.associateWith { group[it] ?: emptyList() }
        .map { it ->
            val app = it.key
            val 최근N일 = it.value.sumOf { if (it.first <= recent) it.second else 0 }
            val 전체기간_이용시간 = it.value.sumOf { it.second }

            listOf(app, 최근N일, 전체기간_이용시간)
        }
        .mapNotNull{ it.takeIf { it -> it[1] <= recently_use && it[2] < total_use } }
        .map { it.first() }
        .toIntArray()
}

private fun main() {
    // [2, 3]
    val v1 = solution(4,5,5,10,arrayOf(
        intArrayOf(1,1,2),
        intArrayOf(1,2,3),
        intArrayOf(2,4,3),
        intArrayOf(3,1,4),
        intArrayOf(5,3,3),
        intArrayOf(5,2,2),
        intArrayOf(7,4,4),
        intArrayOf(8,3,3),
        intArrayOf(10,4,3),
    ))

    // [1, 3]
    val v2 = solution(3,3,10,30,arrayOf(
        intArrayOf(1,2,7),
        intArrayOf(2,1,3),
        intArrayOf(3,1,5),
        intArrayOf(4,2,15),
        intArrayOf(5,2,10),
    ))

    println(v1)
    println(v2)
}