package com.example.kotlinsamples.leetcode.linkedlist

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    "[2,45,678,3]".toLinkedList().let {
        var head = it
        while (head != null) {
            println(head.`val`)
            head = head.next
        }
    }
}

fun String.toLinkedList(): ListNode? {
    var head: ListNode? = null
    this.trim('[', ']')
        .split(',')
        .filter { it != "" }.reversed()
        .map {
            var node = ListNode(it.toInt())
            node.next = head
            head = node
        }
    return head
}

fun ListNode?.toString(): String {
    var head = this
    var res = ""
    while (head != null) {
        res = res + head.`val` + ", "
        head = head.next
    }
    return res.removeSuffix(", ")
}