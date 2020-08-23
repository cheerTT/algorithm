package test.laohuzhengquan._0823;

import hot._nc_023_划分链表;

import java.util.List;

public class _01 {

    class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int x) {this.val = x;}
    }

    // 奇数位的节点移到前面
    // 思路：双指针，拼接链表
    public static ListNode move(ListNode head) {

        ListNode p = head;
        ListNode q = head.next;
        ListNode q_head = head.next;

        while (q != null && q.next != null) {
            p.next = p.next.next;
            q.next = q.next.next;

            p = p.next;
            q = q.next;
        }

        p.next = q_head;

        return head;

    }
}
