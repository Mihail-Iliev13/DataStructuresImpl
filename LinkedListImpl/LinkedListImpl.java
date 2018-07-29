
public class LinkedListImpl {

  private Node head;
  private Node tail;
  private int size;

  public LinkedListImpl(){
    head = null;
    tail = null;
    size = 0;
  }

  public void insertAt(int index, int value){
    int i = 0;

    if(index == 0) {
      addFirst(value);
      return;
    }

    if(index > size() - 1) {
      throw new IndexOutOfBoundsException();
    }

    Node current = head;
    while (i != index){
      current = current.getNext();
      ++i;
    }
    Node newNode = new Node(value);
    current.getPrev().setNext(newNode);
    newNode.setPrev(current.getPrev());
    newNode.setNext(current);
    current.setPrev(newNode);
  }

  public void delete(int value){

    if(head.getValue() == value){
      removeFirst();
      return;
    }

    if(tail.getValue() == value){
      removeLast();
      return;
    }

    Node current = head;
    while (current.getValue() != value){
      current = current.getNext();
    }

    current.getPrev().setNext(current.getNext());
    current.getNext().setPrev(current.getPrev());
  }

  public void addFirst(int value){

    Node newNode = new Node(value);
    if(head == null){
      head = newNode;
      tail = head;
      return;
    }

    if(head.getNext() == null) {
      head = newNode;
      newNode.setNext(tail);
      tail.setPrev(newNode);
      return;
    }

    head.setPrev(newNode);
    newNode.setNext(head);
    head = newNode;
  }

  public void removeFirst(){
    Node newHead = head.getNext();

    if(head.getNext() == null) {
      head = null;
      return;
    }
    head.getNext().setPrev(null);
    head = newHead;
  }

  public void addLast(int value){

    if(tail == null){
      head = new Node(value);
      tail = new Node(value);
      return;
    }

    if (tail.getPrev() == null){

      tail = new Node(value);
      tail.setPrev(head);
      head.setNext(tail);
      return;
    }

    Node newNode = new Node(value);
    newNode.setPrev(tail);;
    tail.setNext(newNode);
    tail = newNode;
  }

  public void removeLast(){

    if(tail.getPrev() == null) {
      head = null;
      tail = null;
      return;
    }

    Node newTail = tail.getPrev();
    newTail.setNext(null);
    tail.setPrev(newTail.getPrev());
    tail = newTail;
  }

  public void printList(){
    StringBuilder sb = new StringBuilder();
    Node current = head;

    while (current != null){
      sb.append(current.getValue()).append(",");
      current = current.getNext();
    }

    if(sb.length() > 0) {
      System.out.println(sb.toString().substring(0, sb.length() - 1));
    } else {
      System.out.println("The list is empty");
    }
  }

  public int getFirst(){
    return head.getValue();
  }

  public int getLast(){
    return tail.getValue();
  }

  public int get(int index){
    int i = 0;

    Node current = head;

    while (i != index) {
      current = current.getNext();
      ++i;
    }
    return current.getValue();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size(){
    int size = 0;
    Node current = head;
    while (current != null){
      size++;
      current = current.getNext();
    }
    return size;
  }

  public boolean contains(int value){
    Node current = head;
    while (current != null){
      if (current.getValue() == value) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  public int indexOf(int value){
    int i = 0;
    Node current = head;
    while (current != null){
      if(current.getValue() == value) {
        return i;
      }
      current = current.getNext();
      ++i;
    }
    return  -1;
  }

  public void set (int index, int value){

    if (index > size() - 1){
      throw new IndexOutOfBoundsException();
    }

    Node current = head;
    int i = 0;
    while (current != null){

      if(i == index){
        current.setValue(value);
        return;
      }
      ++i;
      current = current.getNext();
    }
  }

  public void clear(){
    head = null;
    tail = null;
  }

  public class Node {
    private int value;
    private Node next;
    private Node prev;


    Node(int value){
      setValue(value);
    }

    int getValue() {
      return value;
    }

    void setValue(int value) {
      this.value = value;
    }

    Node getNext() {
      return next;
    }

    void setNext(Node next) {
      this.next = next;
    }

    Node getPrev() {
      return prev;
    }

    void setPrev(Node prev) {
      this.prev = prev;
    }
  }

}
