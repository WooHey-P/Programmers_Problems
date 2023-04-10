
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 * */
fun solution(park: Array<String>, routes: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()

    // 시작 위치
    var sh = -1
    var sw = -1
    park.forEachIndexed { index, s ->
        if(s[0] == 'S'){
            sw = 0
            sh = index
            return@forEachIndexed
        }

        if (s.indexOf('S') > 0){
            sw = s.indexOf('S')
            sh = index
            return@forEachIndexed
        }
    }

    // 이동할 만큼 반복
    routes.forEach {
        val op = it.split(" ").first()
        val n = it.split(" ").last().toInt()

        // 최대 이동 가능한 길이
        val maxWidth = park[0].length
        val maxHeight = park.size

        when (op){
            "E" -> {
                // 이동 후 위치
                val mv = sw + n
                // 벽을 넘어간다면
                if(mv > maxWidth - 1) { return@forEach }
                // 가는 길에 X 가 존재한다면
                if(park[sh].substring(sw, mv + 1).contains("X")){ return@forEach }
                sw += n
            }
            "W" -> {
                val mv = sw - n
                if(mv < 0){ return@forEach }
                if(park[sh].substring(0, sw).contains("X")){ return@forEach }
                sw -= n
            }
            "S" -> {
                val mv = sh + n
                if (mv > maxHeight - 1) { return@forEach }
                val v1 = park.map { str -> str[sw] }.toTypedArray().sliceArray(sh until mv + 1)
                if (v1.contains('X')){ return@forEach }
                sh += n
            }
            "N" -> {
                val mv = sh - n
                if (mv < 0) { return@forEach }
                val v1 = park.map { str -> str[sw] }.toTypedArray().sliceArray(0 until sh)
                if (v1.contains('X')){ return@forEach }
                sh -= n
            }
        }
    }

    return intArrayOf(sh, sw)
}


fun main() {
    println(arrayOf("123","456","789").map{ it[2] }.toTypedArray().sliceArray(1 until (1+1)+1).contains('6'))
//    println(arrayOf("123","456","789").map{ it[2] }.toTypedArray().sliceArray(1 until (1+1)+1).map { print(it) })

    solution(park = arrayOf("SOO","OOO","OOO"), routes = arrayOf("E 2","S 2","W 1")).map { print("$it,") } // 2,1
    println()
    solution(park = arrayOf("SOO","OXX","OOO"), routes = arrayOf("E 2","S 2","W 1")).map { print("$it,") } // 0,1
    println()
    solution(park = arrayOf("OSOOOOOOXOXXOOX", "OOOXXOOOXOOXXOO", "XOOXXOOOOOXOOXO", "OOOOXOOOXOXOOOO"), routes = arrayOf("E 6", "S 4", "W 2","S 2","N 1","E 2")).map { print("$it,") }  // 0,0
    println()

    /**
     * OSOOOOOOXOXXOOX
     * OOOXXOOOXOOXXOO
     * XOOXXOOOOOXOOXO
     * OOOOXOOOXOXOOOO
     * */
    solution(park = arrayOf("XOX","OSO","XXO"), routes = arrayOf("E 1","W 1","S 1","N 1","S 1","E 2","W 2","S 2", "N 2")).map { print("$it,") } // 2,1
    println()

}