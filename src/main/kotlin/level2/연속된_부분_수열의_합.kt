package level2

class 연속된부분수열의합 {
    fun 연속된부분수열의합(sequence: IntArray, k: Int): IntArray {
        var searchSt = 0
        var searchEd = 0
        var st = 0
        var ed = 0
        var minLen = 1000000

        while(searchEd <= sequence.size) {
            val sum = sequence.slice(searchSt..searchEd).sumOf{it}

            if (sum == k) {
                if (ed - st < minLen) {
                    minLen = ed - st
                    st = searchSt
                    ed = searchEd
                }
                searchEd++
            } else if (sum < k) {
                searchEd++
            } else if (sum > k) {
                searchSt++
            }
        }

        return intArrayOf(st, ed)
    }
}

fun main() {
    println(연속된부분수열의합().연속된부분수열의합(intArrayOf(1, 2, 3, 4, 5) ,7))
}