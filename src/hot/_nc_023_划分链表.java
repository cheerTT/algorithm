package hot;

public class _nc_023_划分链表 {

    class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int x) {this.val = x;}
    }

    // 1 4 3 2 5 2
    public ListNode partition(ListNode head, int x) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead; // p 指向小于 x 的最后一个节点
        ListNode q = dummyHead; // q 指向大于等于 x 的最后一个节点

        while (q != null && q.next != null) {
            if (q.next.val < x) {
                if (p == q) {
                    p = p.next;
                    q = q.next;
                } else {

                    ListNode tmp1 = p.next;
                    ListNode tmp2 = q.next;
                    q.next = tmp2.next; // 删除 tmp2

                    // 把 tmp2 接到 p 后面
                    p.next = tmp2;
                    tmp2.next = tmp1;

                    // p 往后移
                    p = p.next;
                }

            } else {
                q = q.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        _nc_023_划分链表 solution = new _nc_023_划分链表();

        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(4);
        ListNode node3 = solution.new ListNode(3);
        ListNode node4 = solution.new ListNode(2);
        ListNode node5 = solution.new ListNode(2);
        ListNode node6 = solution.new ListNode(5);
        ListNode node7 = solution.new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode head = solution.partition(node1, 3);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
