
public class GraphAdjacencyMatrix {

  boolean[][] matrix;

  public GraphAdjacencyMatrix(int N, int M){
    matrix = new boolean[N][M];
  }


  public void addDirectedEdge(int from, int to){
    matrix[from][to] = true;
  }

  public void addEdge (int from, int to) {
    matrix[from][to] = true;
    matrix[to][from] = true;
  }

}
