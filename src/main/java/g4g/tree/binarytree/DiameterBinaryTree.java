package g4g.tree.binarytree;

public class DiameterBinaryTree {

    public static void main (String[] args) {
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
        DiameterBinaryTree diameterBinaryTree = new DiameterBinaryTree();
        System.out.print("\nDiameter of binary tree is - ");
        // expect 3,
        int diameter = diameterBinaryTree.diameterOfBinaryTree(node1);
        System.out.println(diameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return diameterOfBinaryTreeHelper(root)[1];
    }

    // int[0]: longestPath, int[1]: diameter
    public int[] diameterOfBinaryTreeHelper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{1, 0};
        } else if (root.right == null) {
            int[] ret = diameterOfBinaryTreeHelper(root.left);
            ret[1] = Math.max(ret[0], ret[1]);
            ret[0] +=1;
            return ret;
        } else if (root.left == null) {
            int[] ret = diameterOfBinaryTreeHelper(root.right);
            ret[1] = Math.max(ret[0], ret[1]);
            ret[0] +=1;
            return ret;
        } else {
            int[] retL = diameterOfBinaryTreeHelper(root.left);
            int[] retR = diameterOfBinaryTreeHelper(root.right);
            int[] ret = new int[2];
            ret[1] = Math.max(Math.max(retL[1], retR[1]), retL[0] + retR[0]);
            ret[0] = Math.max(retL[0], retR[0]) + 1;
            return ret;
        }
    }
}
