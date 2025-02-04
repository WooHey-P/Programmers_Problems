package level2

var 원본배열 = intArrayOf()
var 타겟 = 3

private fun solution(numbers: IntArray, target: Int): Int {
    원본배열 = numbers
    타겟 = target

    val init = dfs(booleanArrayOf(), true, 0) +
            dfs(booleanArrayOf(), false, 0)

    return init
}

private fun dfs(prevPMList: BooleanArray, 현재부호: Boolean, 현재인덱스: Int): Int {
    val hasChild = 원본배열.size > 현재인덱스 + 1
    val curPMList = prevPMList + 현재부호

    if (hasChild) {
        return dfs(curPMList,true, 현재인덱스 + 1) +
                dfs(curPMList, false, 현재인덱스 + 1)
    } else {
        val newResult = 원본배열.zip(curPMList.asList()) { a, b ->

        }


        val result = 원본배열
            .zip(curPMList.asList()) { item, 부호 -> if (부호) item else -item }
            .sum()

        return if (result == 타겟) 1 else 0
    }
}

private fun main() {
    val v1 = solution(intArrayOf(1, 1, 1, 1, 1), 3)
    println(v1)
}