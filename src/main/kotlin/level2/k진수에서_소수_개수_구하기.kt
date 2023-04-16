package level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */

// 14 --> 3
// 14 / 3 --> 4 ... 2
// 4 / 3 --> 1 ... 1
// 1 / 3 --> 0 ... 1
/**
 * 14 % 3 --> 2
 *
 * */



private fun solution(n: Int, k: Int): Int =
    // n 을 k 진수로 변환 후 0 으로 split
    n.getN(k).toString().split("0")
        // list 에서 빈 값은 필터링
        .filter{ it.isNotBlank() }.map { it.toLong() }
        // prime number 구함
        .count { number -> (number > 1) && (2..Math.sqrt(number.toDouble()).toInt()).none { number % it == 0L } }

// n 을 k 진수로 변환하는 함수
tailrec fun Int.getN(k: Int, m: Long = 1, result: Long = 0): Long =
    if (this == 0) {
        result
    } else {
        (this / k).getN(k, m * 10, result + (this % k) * m)
    }

private fun main() {
    /**
     * 11, 2
     * 11 / 2 --> 5 ... 1
     * 5 / 2 --> 2 ... 1
     * 2 / 2 --> 1 ... 0
     * 1 / 2 --> 0 ... 1
     *
     * 1 + 1*10 + 0*100 + 1*1000
     * */

    println(941503.getN(3))

    val v1 = 941503.getN(3).toString().split("0")
    val v2 = v1.filter{ it != "" }.map { it.toLong() }
    val v3 = v2.map { n -> (n > 1) && (2..Math.sqrt(n.toDouble()).toInt()).none { n % it == 0.toLong() }}


    println(solution(437674,3))
    println(solution(110011,10))
}
