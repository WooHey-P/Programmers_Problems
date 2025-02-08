package level2

data class Task(
    val name: String,
    val start: Int,
    var duration: Int,
) {
    fun endTime() = start + duration
}

class 과제진행하기 {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val 과제목록 = plans
            .map { Task(it[0], it[1].toTime(), it[2].toInt()) }
            .sortedBy {it.start}

        for (cur in 과제목록.indices) {
            val 현재과제 = 과제목록[cur]
            for (nxt in cur+1 until 과제목록.size) {
                val 다음과제 = 과제목록[nxt]

                if (현재과제.endTime() > 다음과제.start) {
                    현재과제.duration += 다음과제.duration
                } else {
                    break;
                }
            }
        }

        return 과제목록.sortedBy{it.endTime()}.map{it.name}.toTypedArray()
    }

    fun 과제진행하기1(plans: Array<Array<String>>): Array<String> {
        val answer = ArrayDeque<String>()
        val stack = ArrayDeque<Task>()
        val taskList = plans.map { Task(it[0], it[1].toTime(), it[2].toInt()) }
            .sortedBy { it.start }
            .toMutableList()

        var currentTime = 0

        taskList.forEachIndexed { _, currentTask ->
            var timeSlice = currentTask.start - currentTime

            while (stack.isNotEmpty() && timeSlice > 0) {
                val tempTask = stack.removeLast()
                if (tempTask.duration >= timeSlice) {
                    tempTask.duration -= timeSlice
                    timeSlice = 0

                    if (tempTask.duration != 0) {
                        stack.addLast(tempTask)
                        continue
                    }
                    answer.add(tempTask.name)
                } else {
                    timeSlice -= tempTask.duration
                    answer.add(tempTask.name)
                }
            }

            stack.addLast(currentTask)
            currentTime = currentTask.start
        }

        val result = mutableListOf<String>()
        result.addAll(answer)
        while (stack.isNotEmpty()) {
            result.add(stack.removeLast().name)
        }

        return result.toTypedArray()
    }

    private fun String.toTime(): Int {
        val (hh, mm) = split(":").map { it.toInt() }
        return hh * 60 + mm
    }
}
