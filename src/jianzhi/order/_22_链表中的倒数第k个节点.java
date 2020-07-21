package jianzhi.order;

public class _22_链表中的倒数第k个节点 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p = head;
        ListNode q = head;

        int i = 0;
        while (q != null && i < k) {
            q = q.next;
            i++;
        }

        if (i != k) return null;

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public static void main(String[] args) {

        _22_链表中的倒数第k个节点 solution = new _22_链表中的倒数第k个节点();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode head1 = solution.getKthFromEnd(node1, 2);

        while (head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }

}
