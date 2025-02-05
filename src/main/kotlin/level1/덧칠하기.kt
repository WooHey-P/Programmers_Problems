package level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */
private fun solution(n: Int, m: Int, section: IntArray): Int {
    var answer: Int = 0
    var end = 0

    section.map {
        if (end <= it) {
            end = it + m
            answer++
        }
    }

    return answer
}