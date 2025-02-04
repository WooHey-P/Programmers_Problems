package level2

/**
 * @param diffs 퍼즐 난이도
 * @param times 퍼즐 소요 시간
 * @param limit 전체 제한 시간
 * @return 제한 시간 내에 퍼즐 해결하기 위한 숙련도 최솟값
 */
private fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
    var minLv = 1
    var maxLv = diffs.maxOf { it }

    /**
     * 시간 내에 문제 풀이 가능한지 체크
     */
    fun isPossible(mLv: Int): Boolean {
        var sum: Long = 0
        val maps = diffs.zip(times)

        for (i in maps.indices) {
            val pLv = maps[i].first
            val curTime = maps[i].second

            // 내 레벨이 더 높다면
            if (pLv <= mLv) {
                sum += curTime
            } else {
                val prevTime = maps[i - 1].second
                sum += (pLv - mLv) * (prevTime + curTime) + curTime.toLong()
            }

            if (limit < sum) return false
        }

        return true
    }

    while (minLv < maxLv) {
        val curLv: Int = (minLv + maxLv) / 2

        if (isPossible(curLv)) {
            maxLv = curLv
        } else {
            minLv = curLv + 1
        }
    }

    return maxLv
}

private fun solution1(diffs: IntArray, times: IntArray, limit: Long): Long {
    var answer: Long = 0

    val diffTimesMap = diffs.zip(times)

    (1 ..1_000_000_000_000_000).forEach { level ->
        answer = level

        var sum = 0L
        diffTimesMap.mapIndexed { idx, (diff, curTime) ->
            if (diff <= level) {
                sum += curTime
            } else {
                repeat((diff.toLong() - level).toInt()) {
                    sum += diffTimesMap[idx - 1].second + curTime
                }
                sum += curTime
            }
        }

        if (sum <= limit) {
            return answer
        }
    }
    return answer
}


private fun main() {
    val v1 = solution(intArrayOf(1, 5, 3), intArrayOf(2, 4, 7), 30)
    println(v1)

    val v2 = solution(intArrayOf(1,4,4,2), intArrayOf(6,3,8,2), 59)
    println(v2)

    val v3 = solution(intArrayOf(1, 99999, 100000, 99995), intArrayOf(9999, 9001, 9999, 9001), 3456789012)
    println(v3)
}
