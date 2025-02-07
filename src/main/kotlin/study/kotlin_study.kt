package study

private fun main() {
    자료구조()
}

private fun 자료구조() {
    // 배열 (가변) 수정 가능
    // val arr = arrayOf() // 오류!! type 을 지정해줘야 함
    val arr1 = arrayOf(1, 2, 3)
    val arr2 = Array(4) { 2 } // size, init
    val arr3 = Array(2) { 3 * 2 }
    val arr4 = Array(2) { it }

    val iArr1 = intArrayOf()
    val iArr2 = intArrayOf(1, 2)

    iArr1 + 1
    iArr1 + 2
    print(iArr1.contentToString())

    // 리스트 (불변) 수정 불가
    val list1 = listOf<Int>()
    val list2 = List<Int>(2) { 0 }
    val list3 = MutableList<Int>(3) { it } // 0 부터 순서대로 3개

    // 스택 (FILO)
    val stack = mutableListOf<Int>() // 가변
    stack.addAll(listOf(1, 2, 3, 4, 5))

    // 큐 (FIFO)
    val queue = java.util.LinkedList<Int>()
    queue.add(1)
    queue.add(2)


    // Collection
    // map
    val map1 = mapOf<Int, Int>() // 불변
    val map2 = mapOf(Pair(1, 2), Pair(3, 4))
    val map3 = hashMapOf<Int, Int>() // 가변


    // 함수들
    val testList = mutableListOf(1, 2, 3, 4, 5)
    testList.removeLast() // 1, 2, 3, 4
    testList.slice(1..2) // 2, 3
    testList.take(2) // 1, 2
    testList.drop(1) // 2, 3, 4, 5
    testList.takeWhile { it % 2 == 0 } // 2  조건이 처음 깨지면, 이후로 버림
    testList.dropWhile { it < 3 } // 3, 4, 5
    testList.filter { it % 2 == 0 } // 2, 4  조건 만족하는거 전체

    testList.sort()
    testList.sortBy { it % 2 } // 단일 속성 기준 정렬
    testList.sortWith(compareBy { it % 2 }) // 커스텀 비교 함수
    testList.maxOf { it }


    println(testList.slice(2..7.let{ if (it > testList.lastIndex) testList.lastIndex else it }))
}