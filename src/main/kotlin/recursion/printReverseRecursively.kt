package recursion

fun main() {
    printTailRecursively(5)
}

fun printReverseRecursively(num: Int) {
    if (num == 0)
        return

    printReverseRecursively(num - 1)
    println(num)
}

fun printTailRecursively(num: Int) {
    var i = 1

    if (i == num)
        return

    println(i)
    printTailRecursively(i + 1)
}