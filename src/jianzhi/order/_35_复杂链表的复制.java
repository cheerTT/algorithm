package jianzhi.order;

import java.util.HashMap;
import java.util.Map;

public class _35_复杂链表的复制 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 通过 HashMap 实现链表的深拷贝
    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        // 复制节点
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 复制指针
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
