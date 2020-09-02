package type.doublepointer.fastslow;

public class TestFstSlow {

    static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode findMidNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // 奇数返回中点，偶数返回中间前一个点
        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode findMidNode1(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // 奇数返回中点，偶数返回中间后一个点
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode node = findMidNode1(node1);

        System.out.println(node.val);
    }
}
