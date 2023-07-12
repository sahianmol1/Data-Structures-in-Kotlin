package graph

fun main() {

    val numberOfVertices = 4
    val adj:ArrayList<ArrayList<Int>> = arrayListOf()

    for (i in 0 until numberOfVertices){
        adj.add(arrayListOf())
    }

    adj.addEdge(0, 1)
    adj.addEdge(0, 2)
    adj.addEdge(1, 2)
    adj.addEdge(1, 3)

    printGraph(adj)

}

fun ArrayList<ArrayList<Int>>.addEdge(u: Int, v: Int) {
    this[u].add(v)
    this[v].add(u)
}

fun printGraph(adj: ArrayList<ArrayList<Int>>) {
    for (i in 0 until adj.size) {
        print("$i -> ")
        for (j in 0 until  adj[i].size) {
            print("${adj[i][j]} ")
        }
        println()
    }
}