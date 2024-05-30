import java.util.LinkedList;

class Graph {
    private int numVertices;
    private int numEdges;
    private LinkedList<int[]> edgeList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.numEdges = 0;
        this.edgeList = new LinkedList<>();
    }

    public void addEdge(int src, int dest) {
        edgeList.add(new int[]{src, dest});
        numEdges++;
    }

    public void printGraph() {
        System.out.println("Edge List:");
        for (int[] edge : edgeList) {
            System.out.println(edge[0] + " - " + edge[1]);
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