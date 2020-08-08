package yuanfudao.linklist;

import java.awt.*;

public class _24_反转链表 {

    class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 迭代
    public ListNode reverse1(ListNode head) {

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

    public ListNode reverse2(ListNode head) {

        if (head == null || head.next == null) return head;

        // 以 head.next 为头结点
        ListNode cur = reverse2(head.next);

        head.next.next = head;
        head.next = null;

        return cur;
    }

    public static void main(String[] args) {

        _24_反转链表 solution = new _24_反转链表();


        ListNode l1 = solution.new ListNode(1);
        ListNode l2 = solution.new ListNode(2);
        ListNode l3 = solution.new ListNode(3);
        ListNode l4 = solution.new ListNode(4);
        ListNode l5 = solution.new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = solution.reverse2(l1);

        System.out.println(res.val);
    }
}
