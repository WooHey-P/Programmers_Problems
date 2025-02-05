package level1

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */
fun main() {
    val answer = solution(arrayOf("muzi", "ryan", "frodo", "neo"), arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"))
    print("answer: $answer")
}

data class Friend (
    val toGift: MutableList<String> = mutableListOf(),
    val fromGift: MutableList<String> = mutableListOf(),
    var giftIndex: Int = 0
)

fun solution(friends: Array<String>, gifts: Array<String>): Int {
    var answer: Int = 0

    // 계산 목적
    var prevMonthFriends: MutableMap<String, Friend> = mutableMapOf()
    // 다음 달 저장 목적
    var nextMonthFriends: MutableMap<String, Friend> = mutableMapOf()

    friends.forEach { friend ->
        prevMonthFriends[friend] = Friend()
        nextMonthFriends[friend] = Friend()
    }

    gifts.forEach { gift ->
        val _from = gift.split(" ")[0]
        val _to = gift.split(" ")[1]

        if (prevMonthFriends.containsKey(_from)) {
            prevMonthFriends[_from]!!.toGift.add(_to)
            prevMonthFriends[_from]!!.giftIndex++
        }

        if (prevMonthFriends.containsKey(_to)) {
            prevMonthFriends[_to]!!.fromGift.add(_from)
            prevMonthFriends[_to]!!.giftIndex--
        }

    }



    return answer
}

/*
 * 1: f1 -> f2 에게 선물 줘야됨
 * 0: 주고 받은 선물 수 동일
 * -1: f1 -> f1 에게 선물 줘야됨
 * */
fun comparePresentGift(f1: Friend, f2: Friend) {
    // f1 과 f2 의 주고 받은 선물 비교
    // 같다면, 선물 지수 비교
}

fun calcMaxReceiveGiftCount(friends: List<Friend>) {
    // return friends 중 선물을 가장 많이 받을 예정인 친구의 받을 선물 수
}