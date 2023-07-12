import arrays.merge
import linkedlist.printTheLinkedList

//Example:

fun main() {
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next!!.next = ListNode(4)

    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next!!.next = ListNode(4)

    println("Lists after merging: ${printTheLinkedList(mergeTwoLists(list1, list2))}")
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 != null && list2 != null) {
        var tail: ListNode? = null
        var head: ListNode? = null

        var a = list1
        var b = list2

        if (a.`val` < b.`val`) {
            tail = a
            head = tail
            a = a.next
        } else {
            tail = b
            head = tail
            b = b.next
        }

        while (a != null && b != null) {
            if (a.`val` <= b.`val`) {
                tail?.next = a
                tail = a
                a = a.next
            } else {
                tail?.next = b
                tail = b
                b = b.next
            }
        }

        if (a == null) {
            tail?.next = b
        } else {
            tail?.next = a
        }

        return head
    }

    return list1 ?: list2
}
