public class node<T> {
    private T data;
    private node<T> next;

    public node(T data, node next) {
        this.data = data;
        this.next = next;
    }
    public node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {return this.data;}
    public void setData(T data) {this.data = data;}
    public node<T> getNext() {return this.next;}
    public void setNext(node<T> next) {this.next = next;}
}
