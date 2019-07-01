package leedcode;

public class mergeTwoLists {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(4);

        ListNode ln2 = new ListNode(1);
        ln2.next = new ListNode(3);
        ln2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(ln1, ln2);
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode listNode;
        if(l1.val < l2.val){
            listNode = new ListNode(l1.val);
            listNode.next = mergeTwoLists(l1.next, l2);
        }else{
            listNode = new ListNode(l2.val);
            listNode.next = mergeTwoLists(l1, l2.next);
        }
        return listNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}