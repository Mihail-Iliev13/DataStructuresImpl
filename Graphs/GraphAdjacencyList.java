import java.util.*;

public class GraphAdjacencyList {

  List<List<Integer>> vertices;

  public GraphAdjacencyList(int n){

    vertices = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      vertices.add(new ArrayList<>());
    }

  }

  public void addDirectedEdge (int x, int y) {
    vertices.get(x).add(y);
  }

  public void addEdge(int x, int y) {
    vertices.get(x).add(y);
    vertices.get(y).add(x);
  }

  public void dfs(int vertex) {
    HashSet<Integer> used = new HashSet<>();
    used.add(vertex);
    dfs(vertex, used);
  }

  private void dfs(int vertex, HashSet<Integer> used) {
    System.out.print(vertex + " ");
    for (int i = 0; i < vertices.get(vertex).size(); i++) {
      int currentVertex =  vertices.get(vertex).get(i);

      if (used.contains(currentVertex)) {
        continue;
      }

      used.add(currentVertex);
      dfs(currentVertex, used);
    }

  }

  public void dfs () {
    Set<Integer> used = new HashSet<>();
    List<Integer> paths = new ArrayList<>();
    for (int vertex = 1; vertex < vertices.size(); vertex++) {
      used.clear();
      used.add(vertex);
      paths.clear();
      paths.add(vertex);

      allDfs(vertex, used, paths);

    }
  }

  private void allDfs(int vertex, Set<Integer> used, List<Integer> paths) {
    System.out.println(paths);
    for (int i = 0; i < vertices.get(vertex).size(); i++) {

      if (used.contains(vertices.get(vertex).get(i))) {
        continue;
      }

      used.add(vertices.get(vertex).get(i));
      paths.add(vertices.get(vertex).get(i));

      allDfs(vertices.get(vertex).get(i), used, paths);

      paths.remove(paths.size() - 1);
      used.remove(vertices.get(vertex).get(i));
    }



  }

  public void bfs (int vertex) {
    Queue<Integer> queue = new ArrayDeque();
    Set<Integer> used = new HashSet<>();
    queue.offer(vertex);
    used.add(vertex);

    while (!queue.isEmpty()) {

      int currentVertex = queue.poll();
      for (int neighbour : vertices.get(currentVertex)) {

        if (!used.contains(neighbour)) {
          used.add(neighbour);
          queue.offer(neighbour);
        }
      }
      System.out.println(currentVertex);
    }
  }

  public int countComponents () {
    HashSet<Integer> used  = new HashSet<>();
    int counter = 0;
    for (int vertex = 1; vertex < vertices.size(); vertex++) {

      if (used.contains(vertex)) {
        continue;
      }

      dfs(vertex, used);
      counter++;
    }
    return counter;
  }
}
