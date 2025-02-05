package level2

/*
private fun solution(targets: Array<IntArray>): Int {
    var answer: Int = 0

    // [ (요격가능부분, 요격여부, id), ... ]
    val realTargets = targets
        // [ ([타겟,타겟,..], false, id), .. ]
        .mapIndexed { id, list ->
            // [1.5, 2.5, ...]
            val l = list.mapIndexed { idx, it ->
                if (list.lastIndex == idx) {
                    null
                } else {
                    (list[idx] + list[idx + 1]) / 2
                }
            }.filter { it != null }
            // 요격가능부분, 요격여부, id
            Triple(l, false, id)
        }

    val flatList = targets.flatMap{ it.toList() }.distinct().sorted()
    val allTargets = (flatList.minOf {it}..flatList.maxOf{it}).map { it + 0.5 }.dropLast(1)
    // [ (타겟, count, [id,id]), ... ]
    val matchedList = allTargets
        .associate {
            val ids = realTargets
                .filter{ it -> it.first.contains(it).map{it.third} }
            Triple(it, ids.size, ids)
        }
        .sortBy {it.second}

    var cnt = 0
    while(realTargets.any { it.second == false }) {
        val fst = matchedList.firstOrNull()

        if (fst != null) {
            realRatget.

            matchedList.removeAt(0)
        }
    }


    return answer
}
*/


private fun solution(targets: Array<IntArray>): Int {
    var ans = 0
    var pos = 0

    targets.sortWith(compareBy({ it[1] }, { it[0] }))

    for (target in targets) {
        if (target[0] >= pos) {
            ans++
            pos = target[1]
        }
    }

    return ans
}
