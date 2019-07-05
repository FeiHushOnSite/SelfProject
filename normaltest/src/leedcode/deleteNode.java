package leedcode;

public class deleteNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next.val = 5;
        node.next.next.val = 1;
        node.next.next.next.val = 9;
        deleteNode(node);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
