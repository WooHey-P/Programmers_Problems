package level1

import java.util.Dictionary

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * */

private fun solution(fees: IntArray, records: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()

    // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
    val initTime = fees[0]
    val initFee = fees[1]
    val unitTime = fees[2]
    val unitFee = fees[3]

    // 차량 dictionary
    var dicCars: Dictionary<String, Int>
    // 시각, 차량번호, 내역(IN, OUT)
    records.forEach {

    }

    return answer
}


private fun main() {
    val fees1 = intArrayOf(180, 5000, 10, 600)
    val records1 = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")

    val fees2 = intArrayOf(120, 0, 60, 591)
    val records2 = arrayOf("16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN")

    solution(fees1, records1).forEach { print("$it, ") }
    println()

    solution(fees2, records2).forEach { print("$it, ") }
    println()
}