package hot;

public class _nc_024_删除有序链表的重复元素 {

    class ListNode {
      int val;
      ListNode next = null;
      public ListNode(int x) { val = x; }
    }

    // 相同的全部删除
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead; // 遍历指针
        ListNode l = head;
        ListNode r = head;

        while (l != null) {
            while (r.next != null && l.val == r.next.val) {
                r = r.next;
            }
            if (l == r) p = p.next;
            else {
                p.next = r.next;
            }

            l = r.next;
            r = r.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        _nc_024_删除有序链表的重复元素 solution = new _nc_024_删除有序链表的重复元素();

        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(1);
        ListNode node3 = solution.new ListNode(1);
        ListNode node4 = solution.new ListNode(2);
        ListNode node5 = solution.new ListNode(2);
        ListNode node6 = solution.new ListNode(2);
        ListNode node7 = solution.new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode head = solution.deleteDuplicates(node1);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
