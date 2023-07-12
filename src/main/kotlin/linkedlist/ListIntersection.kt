package linkedlist

import ListNode

fun main() {
    val headA = ListNode(3)
    headA.next = ListNode(2)
    headA.next?.next = ListNode(1)
    headA.next?.next?.next = ListNode(2)
    headA.next?.next?.next?.next = ListNode(4)

    val headB = ListNode(3)
    headB.next = headA.next?.next?.next
    headB.next?.next = headA.next?.next?.next?.next

    printTheLinkedList(getIntersectionNodeWithHashSet(headA, headB))
}

//O(n2)
fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {

    if (headA == headB) {
        return headA
    }

    var a = headA
    var b = headB

    while (a != null) {
        while (b != null) {
            if (a == b) {
                return a
            } else {
                b = b.next
            }
        }
        b = headB
        a = a.next
    }

    return null
}


// O(m+n)
// better solution
fun getIntersectionNodeWithHashSet(headA:ListNode?, headB:ListNode?):ListNode? {

    val hashSet = hashSetOf<ListNode?>()
    var a = headA
    var b = headB

    while (a != null) {
        hashSet.add(a)
        a = a.next
    }

    while (b != null) {
        if (hashSet.contains(b)) {
            return b
        }
        b = b.next
    }

    return null
}


// O(m+n)
// even better solution
fun getIntersectionNodeWithHashSet2(headA:ListNode?, headB:ListNode?):ListNode? {

    val hashSet = hashSetOf<ListNode?>()
    var current = headA

    while (current != null) {
        hashSet.add(current)
        current = current.next
    }

    current = headB
    while (current != null) {
        if (hashSet.contains(current)) {
            return current
        }
        current = current.next
    }

    return null
}