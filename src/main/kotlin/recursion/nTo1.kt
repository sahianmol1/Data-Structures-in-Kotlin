package recursion

fun main() {
    printRecursively(5)
}

fun printRecursively(num: Int) {
    if (num == 0)
        return

    println(num)
    printRecursively(num - 1)
}