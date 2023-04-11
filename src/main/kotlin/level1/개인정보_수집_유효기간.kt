package level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=kotlin
 * */

data class DT(
    var y: Int,
    var m: Int,
    var d: Int
)
fun String.addDays(days: Int): String {
    val arr = this.split(".")
    val dt = DT(arr[0].toInt(), arr[1].toInt(), arr[2].toInt())

    var sum = dt.y * 12 * 28 + dt.m * 28 + dt.d + days

    dt.y = sum / (12 * 28)
    sum %= (12 * 28)
    dt.m = sum / 28
    sum %= 28
    dt.d = sum

    if(dt.m == 0){
        dt.y -= 1
        dt.m = 12
    }
    return "${dt.y}.${dt.m}.${dt.d}"
}
fun String.isBefore(dt: String): Boolean {
    val v1 = this.split(".")
    val v2 = dt.split(".")

    // 년
    if (v1[0].toInt() != v2[0].toInt()){
        return v1[0].toInt() < v2[0].toInt()
    }
    // 월
    if(v1[1].toInt() != v2[1].toInt()){
        return v1[1].toInt() < v2[1].toInt()
    }
    // 일
    return v1[2].toInt() < v2[2].toInt()
}

fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()

    // 약관 종류
    val dicTerms = terms.associate { it.split(" ").first() to it.split(" ").last() }

    // 약관 만큼 반복
    privacies.forEachIndexed { idx, it ->
        // 약관 동의한 날짜
        val agreeDate = it.split(" ").first()
        // 약관 종류
        val termType = it.split(" ").last()
        // 더해야 하는 월 수
        val termMonth = dicTerms.getValue(termType).toInt()

        // 약관 동의 날짜 + 유효기간 < 오늘  --> 파기해야 함
        if(agreeDate.addDays(termMonth * 28 - 1).isBefore(today)){
            answer += (idx + 1)
        }
    }

    return answer
}

fun main() {
    val td = "2022.02.28"
    val agreedt = "2020.01.28"
    val mn = 23
    val expireDate = agreedt.addDays(28 * mn - 1)
    println("today: $td")
    println("agree: $agreedt, month: $mn")
    println("expireDate: $expireDate")
    println("삭제?: ${expireDate.isBefore(td)}")
    println()

    (1 .. 13).map {
//        println("2022.01.28".addDays(it * 28 - 1))
    }


    println()
    solution(
        today = "2022.05.19",
        terms = arrayOf("A 6", "B 12", "C 3"),
        privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")).map { print("$it,") }
    println()
    solution(
        today = "2020.01.01",
        terms = arrayOf("Z 3", "D 5"),
        privacies = arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")).map { print("$it,") }
    println()
}

fun solution2(today: String, terms: Array<String>, privacies: Array<String>) =
    privacies.indices.filter {
        privacies[it]
            .split(" ").first()     // 날짜만
            .split("\\.".toRegex())           // y,m,d 나눔
            .map(String::toInt)
            .let { (y, m, d) -> (y * 12 * 28) + (m * 28) + d } + (terms.map {it.split(" ")}.associate {(a, b) -> a to b.toInt()}
                .getOrDefault(
                    privacies[it].split(" ").last(),    // 약관 종류
                    0) * 28) <= today.split("\\.".toRegex()).map(String::toInt).let { (y, m, d) -> (y * 12 * 28) + (m * 28) + d }
    }.map { it + 1 }
