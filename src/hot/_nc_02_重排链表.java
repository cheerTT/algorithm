package hot;

import java.util.List;

public class _nc_02_重排链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 快慢指针 + 链表的合并
    // 主要快慢指针的慢指针才是主要的，快指针作用不大
    public void reorderList(ListNode head) {

        if (head == null) return;

        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 翻转
        ListNode p = head;
        ListNode tmp_head= slow.next;
        slow.next = null;
        ListNode q = reverse(tmp_head);

        // 合并
        while (p != null && q != null) {
            ListNode pnext = p.next;
            ListNode qnext = q.next;

            p.next = q;
            q.next = pnext;

            p = pnext;
            q = qnext;
        }

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

        _nc_02_重排链表 solution = new _nc_02_重排链表();

        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(2);
        ListNode node3 = solution.new ListNode(3);
        ListNode node4 = solution.new ListNode(4);
        ListNode node5 = solution.new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
//        node4.next = node5;

//        ListNode head = solution.reverse(node1);

//        while(head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }

        solution.reorderList(node1);

        while(node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.next;
        }
    }
}
