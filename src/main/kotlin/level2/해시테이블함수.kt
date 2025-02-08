package level2

class 해시테이블함수 {
    fun 해시테이블함수(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0

        val sortedList = data
            .sortedArrayWith(
                compareBy<IntArray> { it[col - 1] }
                    .thenByDescending { it[0] })

        return sortedList
            .slice(row_begin - 1..row_end - 1)
            .mapIndexed { idx, arr -> arr.sumOf{ it % (row_begin + idx) } }
            .reduce{acc, it -> acc.xor(it)}

    }
}

fun main() {
    println(해시테이블함수().해시테이블함수(arrayOf(intArrayOf(2,2,6),intArrayOf(1,5,10),intArrayOf(4,2,9),intArrayOf(3,8,3)), 2, 2, 3))
}