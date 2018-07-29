
public class StackImpl {

  private Element topMost;

  public StackImpl() {
    topMost = null;
  }

  public int peek(){
    return topMost.getData();
  }

  public void pop(){
    topMost = topMost.getElementBelow();
  }

  public void push(int value){
    Element element = new Element(value);
    if(topMost != null){
      element.setElementBelow(topMost);
      topMost = element;
    } else {
      topMost = element;
    }
  }

  public boolean isEmpty(){
    return topMost == null;
  }


  public class Element {

    private int data;
    private Element elementBelow;

    Element(int data){
      this.data = data;
    }

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public Element getElementBelow() {
      return elementBelow;
    }

    public void setElementBelow(Element elementBelow) {
      this.elementBelow = elementBelow;
    }
  }

}
