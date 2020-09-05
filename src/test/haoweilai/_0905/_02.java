package test.haoweilai._0905;

import javax.sound.midi.Soundbank;

public class _02 {

    class ListNode {
      int val;
      ListNode next = null;

        public ListNode(int i) {
            i = val;
        }
    }

    public ListNode reverseList (ListNode head) {
        // write code here
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

        _02 solution = new _02();

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

        ListNode res = solution.reverseList(node1);

        while (res != null) {

            System.out.print(res.next + " ");
            res = res.next;
        }
    }

}
