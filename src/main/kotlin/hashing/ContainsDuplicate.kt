package hashing

fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3)))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val hashMap = hashMapOf<Int, Int>()

    if (nums.isEmpty()) {
        return false
    }

    nums.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        if (hashMap[it]!! > 1) {
            return true
        }
    }

    return false
}