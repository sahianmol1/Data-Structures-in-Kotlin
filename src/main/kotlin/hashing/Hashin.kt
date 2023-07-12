package hashing

fun main() {
    val array = listOf<Int>(20, 15, 12 ,13 ,12 ,13, 13 ,18, 20)
    val array2 = listOf<Int>(10, 12, 10, 15, 10, 20, 12, 12, 20)
    println("The number of distinct elements: ${countDistinctElementsWithHashSet(array)}")
    println("The frequencies of array elements: ${getFrequenciesOfArrayElements(array2)}")
    println("The intersected array is: ${intersectUnsortedArrays(array, array2)}")
    println("The intersected array with hash is: ${intersectUnsortedArraysWithHash(array, array2)}")
}

fun countDistinctElements(array: List<Int>): Int {
    if (array.isEmpty() || array.size == 1) {
        return array.size
    }

    if (array.size == 2) {
        return if (array[0] == array[1]) 1 else 2
    }
    var count = 1
    val isTraversed = mutableListOf<Int>()

    for (i in 1 until array.size) {
        if (array[0] != array[i] && !isTraversed.contains(array[i])) {
            count += 1
            isTraversed.add(array[i])
        }
    }

    return count
}

fun countDistinctElementsWithHashSet(array: List<Int>): Int {
    val hashSet = hashSetOf<Int>()

    for (i in array.indices) {
        hashSet.add(array[i])
    }

    return hashSet.size
}

fun getFrequenciesOfArrayElements(array: List<Int>) {
    val hashMap = hashMapOf<Int, Int>()

    for (i in array.indices) {
        if (!hashMap.contains(array[i])) {
            hashMap[array[i]] = 1
        } else {
            val currentValue = hashMap[array[i]]
            if (currentValue != null) {
                hashMap[array[i]] = currentValue + 1
            }
        }
    }

    println(hashMap)
}

fun getFrequenciesOfArrayElementsSimple(array: List<Int>) {
    val hashMap = hashMapOf<Int, Int>()

    for (i in array.indices) {
        hashMap[array[i]] = hashMap.getOrDefault(array[i], 0) + 1
    }

    println(hashMap)
}

fun intersectUnsortedArrays(arrayA: List<Int>, arrayB: List<Int>): List<Int> {
    val intersectedArray = mutableListOf<Int>()

    for (i in arrayA.indices) {
        for (j in arrayB.indices) {
            if (arrayA[i] == arrayB[j]) {
                if (!intersectedArray.contains(arrayA[i])) {
                    intersectedArray.add(arrayA[i])
                }
            }
        }
    }

    return intersectedArray
}

fun intersectUnsortedArraysWithHash(arrayA: List<Int>, arrayB: List<Int>) {
    val hashSet = hashSetOf<Int>()

    for (i in arrayB.indices) {
        hashSet.add(arrayB[i])
    }

    for (i in hashSet.indices) {
        if (hashSet.contains(arrayA[i])) {
            print("${arrayA[i]} ")
        }
    }
}