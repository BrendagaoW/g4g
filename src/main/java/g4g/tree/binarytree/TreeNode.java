package g4g.tree.binarytree;

public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) { val = x; }



    public TreeNode(int value, TreeNode lft, TreeNode rgt) {
        this.val = value;
        this.left = lft;
        this.right = rgt;
    }
}
