package stack

class AStack(val stack: MutableList<Int> = mutableListOf()) {


    fun push(item: Int): List<Int> {
        stack.add(item)
        return stack
    }

    fun pop(): List<Int> {
        return try {
            stack.removeLast()
            stack
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun peek(): Int {
        return stack.last()
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }

}

fun main() {
    val stack: AStack = AStack()

    stack.push(10)
    stack.push(20)
    stack.push(30)

    println(stack.stack)

    println("${stack.peek()}")
    stack.pop()

    stack.peek()

    stack.pop()
    stack.pop()
    stack.pop()

    println(stack.stack)
}