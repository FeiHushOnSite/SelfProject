package leedcode.pojo;

public class DoubleLinkedList {

    private int size;
    private Node head;

    public DoubleLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        if (size == 0) {
            System.out.println("空列表");
            return;
        }
        Node node = head;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    /**
     * 在末尾追加一个node
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            //取到末尾的node
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
            node.setPre(last);
        }

        size++;
    }

    public void insert(int index, Node node) {
        if (index < 0 || index > size) {
            throw new RuntimeException("越界");
        }
        if (node == null) {
            return;
        }
        //插头部
        if (index == 0) {
            if (head == null) {
                head = node;
            } else {
                node.setNext(head);
                head.setPre(node);
            }
        } else {
            //将被插入的位置的父节点
            Node beInsertedNode = head;
            for (int i = 0; i < index - 1; i++) {
                beInsertedNode = beInsertedNode.getNext();
            }
            //插到尾部的话，就不走括号内了
            if (beInsertedNode.getNext() != null) {
                node.setNext(beInsertedNode.getNext());
                beInsertedNode.getNext().setPre(node);
            }

            beInsertedNode.setNext(node);
            node.setPre(beInsertedNode);
        }

        size++;
    }

    /**
     * 根据index查找某个节点
     *
     * @param index
     * @return
     */
    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("越界");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }
}
