package level2

/**
 * @param diffs 퍼즐 난이도
 * @param times 퍼즐 소요 시간
 * @param limit 전체 제한 시간
 * @return 제한 시간 내에 퍼즐 해결하기 위한 숙련도 최솟값
 */
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

private fun solution(diffs: IntArray, times: IntArray, limit: Long): Long {
    val diffTimesMap = diffs.zip(times).sortedBy { it.first }

    var left = 1L
    var right = 1_000_000_000_000_000L
    var answer = right

    while (left <= right) {
        val mid = (left + right) / 2
        var sum = 0L

        for ((diff, curTime) in diffTimesMap) {
            if (diff <= mid) {
                sum += curTime
            } else {
                val extraSteps = (diff - mid)
                if (sum > limit) break
                sum += extraSteps * curTime + curTime
            }
            if (sum > limit) break
        }

        if (sum <= limit) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return answer
}

private fun main() {
    val v1 = solution(intArrayOf(1, 5, 3), intArrayOf(2, 4, 7), 30)
    println(v1)

    val v2 = solution(intArrayOf(1,4,4,2), intArrayOf(6,3,8,2), 30)
    println(v2)
}
