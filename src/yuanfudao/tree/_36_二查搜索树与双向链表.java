package yuanfudao.tree;

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

    private Node pre = null;  // pre 跑到了最后
    private Node head = null;

    public Node treeToDoublyList(Node root) {

        if (root == null) return root;

        inOrder(root);

        head.left = pre;
        pre.right = head;

        return head;
    }

    //
    private void inOrder(Node node) {

        if (node == null) return;

        inOrder(node.left);

        if (pre == null) {
            pre = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;

        inOrder(node.right);
    }
}
