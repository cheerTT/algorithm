package jianzhi.order;

public class _24_反转链表 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode cur = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return cur;
    }

    public ListNode reverseList2(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
