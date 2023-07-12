package stack

import java.util.Stack

fun main() {
    println(isValid("(])"))
}

fun isValid(s: String): Boolean {
    val balanceStack = Stack<Char>()

    if (s.isEmpty() || s.startsWith(')') || s.startsWith('}') || s.startsWith(']')) {
        return false
    }

    s.forEach { char ->
        if (char == '(' || char == '{' || char == '[') {
            balanceStack.push(char)
        }

        if (balanceStack.isNotEmpty()) {
            if (balanceStack.peek() == '(' && char == ')'
                || balanceStack.peek() == '{' && char == '}'
                || balanceStack.peek() == '[' && char == ']'
            ) {
                balanceStack.pop()
            } else if (balanceStack.peek() == '(' && char == ']' || balanceStack.peek() == '(' && char == '}'
                || balanceStack.peek() == '{' && char == ']' || balanceStack.peek() == '{' && char == ')'
                || balanceStack.peek() == '[' && char == '}' || balanceStack.peek() == '[' && char == ')'
            ) {
                return false
            }
        } else {
            return false
        }
    }

    return balanceStack.isEmpty()
}
