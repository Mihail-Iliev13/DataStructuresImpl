
public class HashSetImpl {

  private static final int INITIAL_CAPACITY = 8;
  private static final double LOAD_FACTOR = 0.75;
  private String[] values;
  private int size;
  private int capacity;

  public HashSetImpl(){
    capacity = INITIAL_CAPACITY;
    values = new String[capacity];
    size = 0;
  }


  public void add(String value) {
    if (contains(value)) {
      return;
    }

    size++;
    if (shouldResize()) {
      resize();
    }

    int index = getIndex(value);
    values[index] = value;

  }

  private void resize() {
    capacity *= 2;
    String[] temp = values;
    values = new String[capacity];
    System.arraycopy(temp, 0, values, 0, temp.length);
  }

  private boolean shouldResize() {
    return LOAD_FACTOR * capacity <= size;
  }

  private int getIndex(String value) {

    int hashCode = Math.abs(value.hashCode());
    return hashCode % capacity;

  }

  public void remove(String value){
    if(!contains(value)) {
      return;
    }

    size--;
    int index = getIndex(value);
    values[index] = null;
  }

  public boolean contains(String value){
    int index = getIndex(value);

    if (values[index] == null) {
      return false;
    }

    return values[index].equals(value);
  }

  public int size() {
    return size;
  }

  public int getCapacity() {
    return capacity;
  }
}
