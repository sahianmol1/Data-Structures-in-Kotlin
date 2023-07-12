package heap

class MinHeap(
    var array: IntArray = intArrayOf(),
    private val size: Int = 0,
) {

    fun left(i: Int): Int {
        return 2 * i + 1
    }

    fun right(i: Int): Int {
        return 2 * i + 2
    }

    fun parent(i: Int): Int {
        return (i - 1) / 2
    }
}