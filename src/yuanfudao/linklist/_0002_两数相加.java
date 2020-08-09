package yuanfudao.linklist;

// 链表
public class _0002_两数相加 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    // 输出：7 -> 0 -> 8
    // 思路：按照最长的链表计算，当长度不够的时候，补0
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        int tmp = 0;
        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int val = x + y + tmp;

            tmp = val / 10;
            val = val % 10;

            cur.next = new ListNode(val);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }

        if (tmp > 0) {
            cur.next = new ListNode(tmp);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        _0002_两数相加 solution = new _0002_两数相加();

        ListNode node1 = solution.new ListNode(2);
        ListNode node11 = solution.new ListNode(4);
        ListNode node111 = solution.new ListNode(3);

        ListNode node2 = solution.new ListNode(5);
        ListNode node22 = solution.new ListNode(6);
        ListNode node222 = solution.new ListNode(4);

        node1.next = node11;
        node11.next = node111;
        node111.next = null;

        node2.next = node22;
        node22.next = node222;
        node222.next = null;

        ListNode head = solution.addTwoNumbers(node1, node2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


}
