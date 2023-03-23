
fun solution(park: Array<String>, routes: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()



    var sh = -1
    var sw = -1
    park.forEachIndexed { index, s ->
        if (s.indexOf('S') > 0){
            sw = s.indexOf('S')
            sh = index
            return@forEachIndexed
        }
    }



    return answer
}


fun main() {
    print(solution(park = arrayOf("OOO","OOS","OOO","OXO","OOO"), routes = arrayOf("E 2","S 3","W 1")))
    print(solution(park = arrayOf("SOO","OOO","OOO"), routes = arrayOf("E 2","S 2","W 1")))
}