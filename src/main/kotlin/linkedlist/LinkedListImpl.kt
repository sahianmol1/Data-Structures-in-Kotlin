package linkedlist

import ListNode

data class Node(val data: Int, var next: Node? = null)

fun main() {
//    var head: Node? = Node(10)
//    head?.next = Node(20)
//    head?.next?.next = Node(30)
//    head?.next?.next?.next = Node(40)
//    head?.next?.next?.next?.next = Node(50)
//
//    head = insertAtBegin(head = head, value = 0)
//    head = insertAtBegin(head = head, value = -10)
//    head = insertAtEnd(head = head, value = -20)
//    head = insertAtEnd(head = head, value = -30)
//
//    head = deleteFirst(head)
//
//    head = deleteLast(head)
//
//    head = insertAt(position = 2, value = 201, head = head)
//    head = insertAt(position = 5, value = 401, head = head)

    var head = Node(10)
    head.next = Node(20)
    head.next?.next = Node(30)

    printTheLinkedList(head)

    println("\nItem position in the linked list: ${search(head, -20)}")

    head = reverseTheLinkedListRecursively(head)

    println("\nThe reversed linked list is: ")
    println(printTheLinkedList(head))
}

fun printTheLinkedList(head: Node?) {
    var currentHead: Node? = head
    while (currentHead != null) {
        println(currentHead.data)
        currentHead = currentHead.next
    }
}

fun printTheLinkedList(head: ListNode?) {
    var currentHead: ListNode? = head
    while (currentHead != null) {
        println(currentHead.`val`)
        currentHead = currentHead.next
    }
}

fun printTheLinkedListRecursively(head: Node?) {
    if (head == null) {
        return
    }

    println(head.data)
    printTheLinkedListRecursively(head.next)
}

fun insertAtBegin(head: Node?, value: Int): Node {
    val temp = Node(value)
    temp.next = head
    return temp
}

// check what is the issue in not using .next operator here
fun insertAtEnd(head: Node?, value: Int): Node {
    if (head == null) {
        return Node(data = value)
    }
    var currentHead = head
    while (currentHead?.next != null) {
        currentHead = currentHead.next
    }
    currentHead?.next = Node(value)
    return head
}

fun deleteFirst(head: Node?): Node? {
    return head?.next
}

fun deleteLast(head: Node?): Node? {
    var currentHead = head
    while (currentHead?.next?.next != null) {
        currentHead = currentHead.next
    }
    currentHead?.next = null
    return head
}

fun insertAt(position: Int, head: Node?, value: Int): Node? {
    val temp = Node(data = value)
    if (position == 1) {
        temp.next = head
        return temp
    }

    var currentHead = head
    for (i in 1 until position - 2) {
        currentHead = currentHead?.next
    }

    if (currentHead == null) {
        return head
    }

    temp.next = currentHead.next
    currentHead.next = temp

    return head
}

fun search(head: Node?, value: Int): Int {
    var currentHead = head
    var position = 1

    while (currentHead != null) {
        if (currentHead.data == value) {
            return position
        }
        currentHead = currentHead.next
        position += 1
    }

    return 0
}

fun reverseTheLinkedList(head: Node?): Node {
    var currentHead = head // 20
    var prev: Node? = null // null

    while (currentHead != null) {
        val temp = currentHead.next // 5 // null

        currentHead.next = prev // 20 ka next = null // 5 ka next = 20
        prev = currentHead // 20 // 5
        currentHead = temp // 5 // null
    }

    return prev ?: Node(0)
}

fun reverseTheLinkedListRecursively(head: Node?): Node {
    var cur = head
    var temp: Node? = null

    if(cur == null) {
        return head ?: Node(0)
    }
    else {
        temp = cur.next
        cur.next = null
        cur = temp
        return reverseTheLinkedListRecursively(cur)
    }
}