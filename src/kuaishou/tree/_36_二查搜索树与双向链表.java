package kuaishou.tree;

public class _36_二查搜索树与双向链表 {

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
    };

    private Node head; // 双向链表的表头结点
    private Node pre;  // 前置结点

    public Node treeToDoublyList(Node root) {

        if (root == null) return root;
        dfs(root);

        head.left = pre;
        pre.right = head;

        return head;
    }


    private void dfs(Node node) {

        if (node == null) return;

        dfs(node.left);

        if (pre == null) {
            pre = node;
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;

        dfs(node.right);

    }
}
