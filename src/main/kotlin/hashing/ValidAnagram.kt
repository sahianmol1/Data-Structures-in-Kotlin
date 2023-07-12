package hashing

fun main() {
    println(isAnagram("anagram", "nagaram"))
}

fun isAnagram(s: String, t: String): Boolean {
    val hashMap = hashMapOf<Char, Int>()

    s.forEachIndexed { index, char ->
        hashMap[char] = hashMap.getOrDefault(char, 0) + 1
    }

    t.forEach { char ->
        hashMap[char] = hashMap.getOrDefault(char, 0) - 1
    }

    hashMap.values.forEach {
        if (it != 0) return false
    }

    return true
}