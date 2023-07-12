package twopointers

fun main() {
    println(isPalindrome("0P"))
}

fun isPalindrome(s: String): Boolean {
    val result = s.filter { it.isLetterOrDigit() }
        .map { it.toLowerCase() }

    return result == result.reversed()
}
