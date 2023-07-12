package arrays

fun main() {
    merge(intArrayOf(10, 20, 30), 3, intArrayOf(1, 2, 3), 3)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    val mergedArray = intArrayOf().toMutableList()

    for (i in 0 .. m-1) {
        for (j in 0 .. n-1) {
            if (nums1[i] >= nums2[j]) {
                mergedArray.add(nums2[j])
            } else {
                mergedArray.add(nums1[i])
            }
        }
    }

    println(mergedArray)
}