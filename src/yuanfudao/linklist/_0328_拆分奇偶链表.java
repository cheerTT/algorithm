package yuanfudao.linklist;

// 相对位置保持不变
// 奇数号元素放在一起，偶数号元素放在一起
// 不是指元素具体的值
public class _0328_拆分奇偶链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 双指针，分别指向奇数起始位置和偶数起始位置
    // 注意保存偶数起始位置，作最后连接用
    public ListNode oddEvenList(ListNode head) {

        if (head == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode even_head = head.next;

        while (even != null && even.next != null) {
            // 连接指针
            odd.next = even.next;
            even.next = even.next.next;
            // 更改指向
            odd = odd.next;
            even = even.next;
        }

        // 奇节点尾巴连接偶节点头
        odd.next = even_head;

        return head;
    }

    public static void main(String[] args) {

        _0328_拆分奇偶链表 solution = new _0328_拆分奇偶链表();

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

        ListNode head = solution.oddEvenList(node1);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
