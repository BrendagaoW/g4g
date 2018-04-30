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
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        MorrisTraversal morrisTraversal = new MorrisTraversal();

        // expect: 4 2 5 1 3
        morrisTraversal.inOrderMorrisTraversal(node1);

        System.out.println("");

        // expect: 1 2 4 5 3
        morrisTraversal.preOrderMorrisTraversal(node1);
    }

    // Time O(n)
    // Space O(1)
    private void inOrderMorrisTraversal(BinaryTreeNode node) {
        System.out.print("InOrder: ");
        BinaryTreeNode current = node;
        while (current != null) {
            if (null == current.getLft()) {
                System.out.print(current.getValue() + " ");
                current = current.getRgt();
            } else {
                BinaryTreeNode predecessor = current.getLft();
                while (null != predecessor.getRgt() && current != predecessor.getRgt()) {
                    predecessor = predecessor.getRgt();
                }
                if (predecessor.getRgt() == null) {
                    // add link
                    predecessor.setRgt(current);
                    current = current.getLft();
                } else {
                    // remove link
                    System.out.print(current.getValue() + " ");
                    predecessor.setRgt(null);
                    current = current.getRgt();
                }
            }
        }
    }

    // Time O(n)
    // Space O(1)
    private void preOrderMorrisTraversal(BinaryTreeNode node) {
        System.out.print("preOrder: ");
        BinaryTreeNode current = node;
        while (current != null) {
            if (null == current.getLft()) {
                System.out.print(current.getValue() + " ");
                current = current.getRgt();
            } else {
                BinaryTreeNode predecessor = current.getLft();
                while (null != predecessor.getRgt() && current != predecessor.getRgt()) {
                    predecessor = predecessor.getRgt();
                }
                if (null == predecessor.getRgt()) {
                    // add link
                    System.out.print(current.getValue() + " ");
                    predecessor.setRgt(current);
                    current = current.getLft();
                } else {
                    // remove link
                    predecessor.setRgt(null);
                    current = current.getRgt();
                }
            }
        }
    }
}
