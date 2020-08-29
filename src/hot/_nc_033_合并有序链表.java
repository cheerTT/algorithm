package hot;

public class _nc_033_合并有序链表 {

    class ListNode {
      int val;
      ListNode next = null;
      ListNode(int v) { val = v; }
    }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }

        if (p != null) {
            cur.next = p;
        }

        if (q != null) {
            cur.next = q;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        _nc_033_合并有序链表 solution = new _nc_033_合并有序链表();
        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(3);
        ListNode node3 = solution.new ListNode(2);
        ListNode node4 = solution.new ListNode(4);
        node1.next = node2;
        node3.next = node4;

        ListNode head = solution.mergeTwoLists(node1, node3);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
