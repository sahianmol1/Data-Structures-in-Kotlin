package arrays

fun main() {
    println(removeElement(intArrayOf(1, 2, 2, 3, 4, 3, 4, 5, 3, 3), 3))
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    return nums.filter { num ->
        num != `val`
    }.size
}