package level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355#
 */
class 크기가작은부분문자열 {
    private fun 크기가작은부분문자열1(t: String, p: String): Int {
        return (0..t.length - p.length)
            .map{ t.substring(it until it + p.length) }
            .count { it <= p }
    }

    fun 크기가작은부분문자열(t: String, p: String): Int {
        var answer: Int = 0

        repeat(t.length - p.length + 1) { st ->
            val num = t
                .slice(st..(st + p.length - 1))
                .toLong()

            if (num <= p.toLong()) {
                answer++
            }
        }

        return answer
    }
}