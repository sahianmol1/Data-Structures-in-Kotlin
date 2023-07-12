package recursion

fun main() {
    print(" ${fib(7)}")
}

fun fib(num: Int): Int {
    if (num <= 1)
        return num

    return fib(num - 1) + fib(num - 2)
}