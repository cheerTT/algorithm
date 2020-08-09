package yuanfudao.linklist;

import java.util.List;

public class _0092_反转链表2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 反转从 m 位置到 n位置的链表
    // 思路：需要头结点，找到 m, n对应的元素，以及前驱和后继
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = head;
        ListNode q = head;

        ListNode pre = dummyHead;
        ListNode next = null;

        int i = 1;
        int j = 1;

        while (q != null) {
            if (i < m) {
                pre = p;
                p = p.next;
                i++;
            }
            if (j < n) {
                q = q.next;
                j++;
            }

            if (j == n) break;
        }

        next =  q.next;
        q.next = null;
        ListNode node = reverse(p);

        pre.next = node;
        p.next = next;

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

        _0092_反转链表2 solution = new _0092_反转链表2();

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

        ListNode head = solution.reverseBetween(node1, 1, 1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
