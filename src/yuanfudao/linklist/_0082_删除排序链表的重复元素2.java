package yuanfudao.linklist;

public class _0082_删除排序链表的重复元素2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 删除所有重复的元素
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead; // 从 dummyHead开始遍历的指针
        // 记录相同元素的左右边界指针
        ListNode l = head;
        ListNode r = head;

        while (l != null) {
            // 确定相同元素的左右区间
            while (r.next != null && l.val == r.next.val) {
                r = r.next;
            }
            // 如果循环后 l 和 r 相同，说明没有发生不同元素
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

        _0082_删除排序链表的重复元素2 solution = new _0082_删除排序链表的重复元素2();

        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(2);
        ListNode node3 = solution.new ListNode(3);
        ListNode node4 = solution.new ListNode(3);
        ListNode node5 = solution.new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = solution.deleteDuplicates(node1);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
