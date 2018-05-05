package g4g.tree.binarytree;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 */
public class ConvertBST2GreaterTree {

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

        ConvertBST2GreaterTree convertBST2GreaterTree = new ConvertBST2GreaterTree();
        // expect: 3 4 9 11 15
        convertBST2GreaterTree.convertBSTHelper(node1);
    }

    public void convertBSTHelper(TreeNode root) {
        TreeNode curNode = root;
        int preV = 0;
        while(curNode != null) {
            if (curNode.right == null) {
                curNode.val += preV;
                preV = curNode.val;
                System.out.print(curNode.val + " ");
                curNode = curNode.left;
            } else {
                TreeNode predecsser = curNode.right;
                while (predecsser.left != null && predecsser.left != curNode) {
                    predecsser = predecsser.left;
                }
                if (predecsser.left == null) {
                    predecsser.left = curNode;
                    curNode = curNode.right;
                } else {
                    predecsser.left = null;
                    curNode.val += preV;
                    preV = curNode.val;
                    System.out.print(curNode.val +" ");
                    curNode = curNode.left;
                }
            }
        }
    }
}
