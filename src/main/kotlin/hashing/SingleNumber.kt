package hashing

fun main() {
    println(singleNumber(intArrayOf(4,1,2,1,2)))
}

fun singleNumber(nums: IntArray): Int {
    val hashMap = hashMapOf<Int, Int>()

    nums.forEachIndexed { index, item ->
        hashMap[item] = hashMap.getOrDefault(item, 0) + 1
    }

    hashMap.keys.forEach {
        if (hashMap[it] == 1) {
            return it
        }
    }

    return 0
}