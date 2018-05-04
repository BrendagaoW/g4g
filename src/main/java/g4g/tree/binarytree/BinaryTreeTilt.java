package g4g.tree.binarytree;

public class BinaryTreeTilt {

    public static void main (String[] args) {
        BinaryTreeNode node5 = new BinaryTreeNode(5,null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4,null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node5, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, null);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println(findTilt(node1));
    }

    public static int findTilt(BinaryTreeNode root) {
        // ret[0] = treeSum, ret[1] = tilt
        int[] ret = new int[2];
        return findTiltRec(root)[1];
    }

    // rec 遍历， time O(n)
    public static int[] findTiltRec(BinaryTreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] retL = findTiltRec(root.getLft());
        int[] retR = findTiltRec(root.getRgt());
        int[] ret = new int[2];
        ret[0] = root.getValue() + retL[0] + retR[0];
        ret[1] = Math.abs(retL[0] - retR[0]) + retL[1] + retR[1];
        return ret;
    }

}
