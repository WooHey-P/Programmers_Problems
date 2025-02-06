package level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
private class 달리기경주 {
    fun 달리기경주(players: Array<String>, callings: Array<String>): Array<String> {

//        Dictionary<string, int> dic = new Dictionary<string, int>();
//        for(int i = 0; i < players.Length; i++)
//        {
//            dic.Add(players[i], i);
//        }
//
//        foreach (string str in callings)
//        {
//            int ranking = dic[str];
//            string player = players[ranking-1];
//
//            players[ranking-1] = str;
//            players[ranking] = player;
//
//            dic[str]--;
//            dic[player]++;
//        }
//
//        return players;

        val names = players.associateWith{players.indexOf(it)}.toMutableMap()
        callings.map { name ->
            val curPos = names[name]!!
            val target = players[curPos - 1]

            players[curPos-1] = name
            players[curPos] = target

            names[name] = names[name]!! -1
            names[target] = names[target]!! + 1
        }

        return players

        /*val pMap = players.associate{ it to players.indexOf(it) }.toMutableMap()

        callings.map { name ->
            val upTargetPos = pMap[name]!!
            val downTarget = pMap.filter{it.value == upTargetPos - 1}.keys.first()

            // swap pos
            pMap[name] = upTargetPos - 1
            pMap[downTarget] = upTargetPos
        }

        val swappedMap = pMap.entries.associate{ (k,v) -> v to k }.toSortedMap()

        return swappedMap.values.toList().toTypedArray()*/

        // name, 현재위치
//        val pMap = players.associateWith{ players.indexOf(it) }.toMutableMap()
//
//        callings.map { name ->
//            val currentPos = pMap[name]!!
//            val downName = players[currentPos - 1]
//
//            pMap[name] = currentPos - 1
//            pMap[downName] = currentPos
//        }
//
//        val queue = java.util.LinkedList<String>()
//        pMap.map { (name, pos) ->
//            queue.add(pos, name)
//        }
//
//        return queue.toList().toTypedArray()


//        val names = callings.groupBy { it }.map { Pair(it.key, it.value.size) }
//        val queue = java.util.LinkedList<String>()
//        players.map{queue.add(it)}
//
//        names.map { (name, cnt) ->
//            queue.remove(name)
//            queue.add(cnt, name)
//        }
//
//        return queue.reversed().toList().toTypedArray()
    }
}

private fun main() {
    val v1 = 달리기경주().달리기경주(arrayOf("mumu", "soe", "poe", "kai", "mine"), arrayOf("kai", "kai", "mine", "mine"))
    println(v1)
}