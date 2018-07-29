
import java.util.Arrays;

public class ArrayListImpl {

  private int[] array;
  private static final int INITIAL_LENGTH = 4;
  private int size;

  public ArrayListImpl(){
    this.size = 0;
    this.array = new int[INITIAL_LENGTH];
  }

  private void resize(){
    array = Arrays.copyOf(array, array.length * 2);
  }

  public void add(int i){
    array[size] = i;
    size++;
    if(size == array.length){
      resize();
    }
  }

  public void add(int index, int i){
    if(index > size){
      throw new IndexOutOfBoundsException();
    }

    System.arraycopy(array, index, array, index + 1, size + 1 - index);
    array[index] = i;
    size++;

    if(size == array.length){
      resize();
    }
  }

  public int size(){
    return size;
  }

  public void remove(int number){
    deleteAt(indexOf(number));
  }

  public void deleteAt(int index){
    System.arraycopy(array, index + 1, array, index, size - index);
    size--;
  }

  public int indexOf(int value){

    for (int i = 0; i < size; i++) {
      if(array[i] == value){
        return i;
      }
    }
    return -1;
  }

  public int get(int index){
    if(index >= size){
      throw new ArrayIndexOutOfBoundsException();
    }
    return array[index];
  }

  public void set(int index, int value) {
    array[index] = value;
  }

  public boolean contains(int value){
    return indexOf(value) != -1;
  }

  public void printList(){
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(array[i]).append(", ");
    }
    System.out.println(sb.substring(0,sb.length() - 2));
  }
}
