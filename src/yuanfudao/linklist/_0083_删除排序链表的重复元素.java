package yuanfudao.linklist;

public class _0083_删除排序链表的重复元素 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 使得每个元素都是只出现一次
    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                // 不能每次指针都要向后移，当出现三个以上连续相同的数的时候，明显不符合条件
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        _0083_删除排序链表的重复元素 solution = new _0083_删除排序链表的重复元素();

        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(2);
        ListNode node3 = solution.new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode head = solution.deleteDuplicates(node1);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
