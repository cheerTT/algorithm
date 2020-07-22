package jianzhi.order;

public class _36_二叉搜索树与双向链表 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node pre = null;  // 当前节点的前一个节点
    private Node head = null; // 双向链表的表头结点

    // 二查搜索树的中序遍历总是可以保证是有序的
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        inorder(root);

        // 首尾相连
        pre.right = head;
        head.left = pre;

        return head;
    }

    private void inorder(Node cur) {

        if (cur == null) return;

        inorder(cur.left);

        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }

        cur.left = pre;
        pre = cur;

        inorder(cur.right);
    }
}
