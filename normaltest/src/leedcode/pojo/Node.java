package leedcode.pojo;

/**
 * 双链表的node
 */
public class Node {
    private String data;
    private Node next;
    private Node pre;

    public Node() {
    }

    public Node(String data, Node next, Node pre) {
        this.data = data;
        this.next = next;
        this.pre = pre;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}
