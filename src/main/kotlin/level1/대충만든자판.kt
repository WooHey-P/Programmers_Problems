package level1

class 대충만든자판 {
    fun 대충만든자판(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()


        var notFound = false
        targets.map { target ->
            var sum = 0

            target.map { t ->
                val findList = keymap.mapNotNull { str ->
                    val strList = str.toList()
                    var pos: Int? = null
                    strList.firstOrNull { it == t }.let {
                        pos = strList.indexOf(it)
                    }
                    pos
                }

                if (findList.isEmpty()) {
                    notFound = true
                } else {
                    sum += findList.minOf{it}
                }
            }

            answer + sum
        }

        if (notFound) {
            return intArrayOf(-1)
        } else {
            return answer
        }
    }
}