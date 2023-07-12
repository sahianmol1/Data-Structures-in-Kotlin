fun main() {
    print( romanToInt("CCCCIC") )
}
fun romanToInt(str: String): Int {
    val symbolHashMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var result = 0;

    str.toCharArray().forEachIndexed { index, char ->
        val currentCharValue = symbolHashMap.getOrDefault(char, 0)
        val nextCharValue: Int = if (index + 1 < str.length) symbolHashMap.getOrDefault(str[index+1], 0) else 0

        if (currentCharValue >= nextCharValue){
            result += currentCharValue
        } else {
            result -= currentCharValue
        }
    }

    return result
}
