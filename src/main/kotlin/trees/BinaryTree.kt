package trees

import java.util.Stack

data class Tree(
    val data: Int,
    var left: Tree? = null,
    var right: Tree? = null
)

fun main() {
    val root = Tree(10)
    root.left = Tree(20)
    root.right = Tree(30)

    root.left?.left = Tree(40)
    root.left?.right = Tree(50)

    postorderTraversal(root).forEach {
        println("----------------------")
        println(it)
    }
}

fun inorderTraversal(root: Tree?) : List<Int> {
    root ?: return listOf()
    return  inorderTraversal(root.left) + listOf(root.data) + inorderTraversal(root.right)
}

fun postorderTraversal(root: Tree?): List<Int> {
    root ?: return listOf()
    return postorderTraversal(root.left) + postorderTraversal(root.right) + listOf(root.data)
}

fun preorderTraversal(root: Tree?): List<Int> {
    root ?: return listOf()
    return listOf(root.data) + preorderTraversal(root.left) + preorderTraversal(root.right)
}
