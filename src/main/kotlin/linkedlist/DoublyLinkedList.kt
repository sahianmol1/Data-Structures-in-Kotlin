data class Node(
    val data: Int,
    var prev: Node? = null,
    var next: Node? = null,
)

fun main() {

    var head = Node(data = 0)
    val temp1 = Node(data = 10)
    val temp2 = Node(data = 20)
    val temp3 = Node(data = 30)

    head.next = temp1

    temp1.prev = head
    temp1.next = temp2

    temp2.prev = temp1
    temp2.next = temp3

    temp3.prev = temp2

    head = head.insertBegin(data = 40)

    printDoublyLinkedList(head)

    head = reverseDoublyLinkedList(head) ?: Node(0)

    println("\n The reversed doubly linked list")

    printDoublyLinkedList(head)
}

fun printDoublyLinkedList(head: Node?) {
    var currentHead = head

    while(currentHead != null) {
        println(currentHead.data)
        currentHead = currentHead.next
    }
}

fun Node?.insertBegin(data: Int): Node {
    val temp = Node(data = data)
    temp.next = this
    this?.prev = temp
    return temp
}

fun reverseDoublyLinkedList(head: Node?): Node? {
    var currentHead = head

    while(currentHead != null) {
        val temp = currentHead.next
        currentHead.next = currentHead.prev
        currentHead.prev = temp

        currentHead = temp
    }

    return currentHead
}