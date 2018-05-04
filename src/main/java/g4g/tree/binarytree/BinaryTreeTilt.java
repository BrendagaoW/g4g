package g4g.tree.binarytree;

public class BinaryTreeTilt {

    public static void main (String[] args) {
        TreeNode node5 = new TreeNode(5,null, null);
        TreeNode node4 = new TreeNode(4,null, null);
        TreeNode node3 = new TreeNode(3, node5, null);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(findTilt(node1));
    }

    public static int findTilt(TreeNode root) {
        // ret[0] = treeSum, ret[1] = tilt
        int[] ret = new int[2];
        return findTiltRec(root)[1];
    }

    // rec 遍历， time O(n)
    public static int[] findTiltRec(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] retL = findTiltRec(root.left);
        int[] retR = findTiltRec(root.right);
        int[] ret = new int[2];
        ret[0] = root.val + retL[0] + retR[0];
        ret[1] = Math.abs(retL[0] - retR[0]) + retL[1] + retR[1];
        return ret;
    }

}
