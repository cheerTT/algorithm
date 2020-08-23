package hot;

import java.util.List;

public class _nc_003_链表中环的入口节点 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 寻找环的入口节点
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode meetNode = meet(head);
        if (meetNode == null) return null;

        ListNode slow = meetNode;
        ListNode fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // 寻找第一次相遇节点，若不存在返回 null
    private ListNode meet(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
