package jianzhi.order;

public class _25_合并两个排序链表 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 1、需要头尾指针
    // 2、确定头结点指向 l1 or l2
    // 3、循环判断
    // 4、接上结尾
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // p, q 指针分别指向两个节点
        ListNode p = l1;
        ListNode q = l2;

        // 维护新链表的首尾节点
        ListNode head = null;
        ListNode tail = null;

        if (p.val < q.val) {
            head = tail = p;
            p = p.next;
        } else {
            head = tail = q;
            q = q.next;
        }

        while (p != null && q != null) {
            if (p.val < q.val) {
                tail.next = p;
                tail = p;
                p = p.next;
            } else {
                tail.next = q;
                tail = q;
                q = q.next;
            }
        }

        if (p != null) {
            tail.next = p;
        }

        if (q != null) {
            tail.next = q;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node33 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node11.next = node22;
        node22.next = node33;
        node33.next = null;

        _25_合并两个排序链表 solution = new _25_合并两个排序链表();
        ListNode h = solution.mergeTwoLists(node1, node11);

        while (h != null) {
            System.out.print(h.val + " ");
             h = h.next;
        }
    }
}
