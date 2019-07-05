package leedcode;


import java.util.Arrays;
import java.util.List;

/**
 * 双向链表快排
 */
public class DoubleLinkedListQuickSort {

    static class Node {
        int value;
        Node pre;
        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (this.next == null) {
                return String.valueOf(this.value);
            }
            return this.value + "->" + this.next.toString();
        }
    }

    /**
     * 参数为头节点和尾节点
     */
    public static void quickSort(Node head, Node tail) {
        if (head == null || tail == null || head == tail || head.next == tail) {
            return;
        }

        if (head != tail) {
            Node mid = getMid(head, tail);
            quickSort(head, mid);
            quickSort(mid.next, tail);
        }
    }

    public static Node getMid(Node start, Node end) {
        int base = start.value;
        while (start != end) {
            while (start != end && base <= end.value) {
                end = end.pre;
            }
            start.value = end.value;
            while (start != end && base >= start.value) {
                start = start.next;
            }
            end.value = start.value;
        }
        start.value = base;
        return start;
    }

    /**
     * 使用如内部实现使用双向链表的LinkedList容器实现的快排
     */
    public static void quickSort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(List<Integer> list, int i, int j) {
        if (i < j) {
            int mid = partition(list, i, j);
            partition(list, i, mid);
            partition(list, mid + 1, j);
        }
    }

    private static int partition(List<Integer> list, int i, int j) {
        int baseVal = list.get(i);
        while (i < j) {
            while (i < j && baseVal <= list.get(j)) {
                j--;
            }
            list.set(i, list.get(j));
            while (i < j && baseVal >= list.get(i)) {
                i++;
            }
            list.set(j, list.get(i));
        }
        list.set(i, baseVal);
        return i;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        Node node6 = new Node(0);

        node1.next = node2;
        node2.pre = node1;

        node2.next = node3;
        node3.pre = node2;

        node3.next = node4;
        node4.pre = node3;

        node4.next = node5;
        node5.pre = node4;

        node5.next = node6;
        node6.pre = node5;

        System.out.println("Origin link: " + node1);
        quickSort(node1, node6);
        System.out.println("Sorted link: " + node1);

        Integer[] l = {2, 3, 4, 1, 0, 5};
        // 可在此处使用LinkedList容器存储
        List<Integer> list = Arrays.asList(l);
        quickSort(list);
        System.out.println("Sorted list: " + list);
        long end = System.currentTimeMillis();
        System.out.println("消耗的运行时间为:" + (end - start));
    }

}