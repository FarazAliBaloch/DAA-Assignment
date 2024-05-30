import java.util.LinkedList;

class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
        adjacencyList[dest].add(src);
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.printGraph();
    }
}