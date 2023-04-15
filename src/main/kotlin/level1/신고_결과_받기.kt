package level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    var answer: IntArray = intArrayOf()

    // 신고 결과를 distinct 처리 후 저장
    val reportResult =
        report.map { it.split(" ") }
        .groupBy({ it[0] }, { it[1] })
        .mapValues{ (_,values) -> values.distinct() }

    // 누가 몇번 신고 당한지
    val result = mutableMapOf<String, Int>()
    reportResult.forEach { it.value.forEach { result[it] = result.getOrDefault(it, 0) + 1 }}

    // 처리결과 이메일 통보 횟수
    id_list.forEach { answer += reportResult[it]?.filter { result.filter { it.value >= k }.contains(it) }?.size ?: 0 }

    return answer
}


fun main() {
    // [2,1,1,0]
    solution(
        id_list = arrayOf("muzi", "frodo", "apeach", "neo"),
        report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),
        k = 2).map { print(it) }

    // [0,0]
    solution(
        id_list = arrayOf("con", "ryan"),
        report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
        k = 3).map { print(it) }
}

/**
 * 프로그래머스의 가장 인기있는 코드...
 * */
fun solution2(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
    report.map { it.split(" ") }
        .groupBy { it[1] }
        .asSequence()
        .map { it.value.distinct() }
        .filter { it.size >= k }
        .flatten()
        .map { it[0] }
        .groupingBy { it }
        .eachCount()
        .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }