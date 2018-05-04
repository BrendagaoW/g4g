package g4g.tree.binarytree;

/**
 * reference:
 * 1. https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * 2. https://www.youtube.com/watch?v=wGXB9OWhPTg&t=619s
 */
public class MorrisTraversal {

    public static void main(String[] args) {

        /* Constructed binary tree is
               1
             /   \
            2      3
          /  \
        4     5
        */
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);

        MorrisTraversal morrisTraversal = new MorrisTraversal();

        // expect: 4 2 5 1 3
        morrisTraversal.inOrderMorrisTraversal(node1);

        System.out.println("");

        // expect: 1 2 4 5 3
        morrisTraversal.preOrderMorrisTraversal(node1);
    }

    // Time O(n)
    // Space O(1)
    private void inOrderMorrisTraversal(TreeNode node) {
        System.out.print("InOrder: ");
        TreeNode current = node;
        while (current != null) {
            if (null == current.left) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (null != predecessor.right && current != predecessor.right) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    // add link
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // remove link
                    System.out.print(current.val + " ");
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    // Time O(n)
    // Space O(1)
    private void preOrderMorrisTraversal(TreeNode node) {
        System.out.print("preOrder: ");
        TreeNode current = node;
        while (current != null) {
            if (null == current.left) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (null != predecessor.right && current != predecessor.right) {
                    predecessor = predecessor.right;
                }
                if (null == predecessor.right) {
                    // add link
                    System.out.print(current.val + " ");
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // remove link
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
}
