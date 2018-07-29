
import java.util.ArrayList;
import java.util.List;

public class GraphSetOfEdges {

  private List<Pair> listOfPairs = new ArrayList<Pair>();

  public void addEdge (int from, int to) {
    listOfPairs.add(new Pair(from, to));
  }

  class Pair {
    int from;
    int to;

    Pair(int from, int to) {
      this.from = from;
      this.to = to;
    }

  }
}
