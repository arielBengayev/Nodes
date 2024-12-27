public class binNode<T> {
    private T data;
    private binNode<T> next;
    private binNode<T> prev;


    public binNode(T data) { this.data = data; this.next = null; this.prev = null; }
    public binNode(T data, binNode<T> next, binNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public binNode<T> getNext() { return next; }
    public void setNext(binNode<T> next) { this.next = next; }
    public binNode<T> getPrev() { return prev; }
    public void setPrev(binNode<T> prev) { this.prev = prev; }
}
