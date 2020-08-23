package hot;

public class _nc_025_删除有序链表的重复元素 {

    class ListNode {
      int val;
      ListNode next = null;
      public ListNode(int x) {this.val = x;}
    }

    // 相同留一个
    public ListNode deleteDuplicates (ListNode head) {

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
