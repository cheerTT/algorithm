package yuanfudao.linklist;

public class _0025_K个一组翻转链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) return null;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode start = null;
        ListNode end = dummyHead;
        ListNode pre = dummyHead;
        ListNode next = null;


        while (end.next != null) {
            int i = 0;
            while (i < k) {
                end = end.next;
                if (end == null) break;
                i++;
            }

            if (i < k) break;

            start = pre.next; // 起始
            next = end.next; // 结束的下一个
            end.next = null;

            pre.next = reverse(start);
            start.next = next;

            pre = start;
            end = start;
        }

        return dummyHead.next;

    }

    private ListNode reverse(ListNode head) {

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

    public static void main(String[] args) {

        _0025_K个一组翻转链表 solution = new _0025_K个一组翻转链表();

        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(2);
        ListNode node3 = solution.new ListNode(3);
        ListNode node4 = solution.new ListNode(4);
        ListNode node5 = solution.new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode head = solution.reverseKGroup(node1, 2);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
