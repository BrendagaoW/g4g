package g4g.tree.binarytree;

public class BinaryTreeNode {

    private int value;

    private BinaryTreeNode lft;

    private BinaryTreeNode rgt;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
        this.lft = null;
        this.rgt = null;
    }

    public BinaryTreeNode(int value, BinaryTreeNode lft, BinaryTreeNode rgt) {
        this.value = value;
        this.lft = lft;
        this.rgt = rgt;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLft() {
        return lft;
    }

    public void setLft(BinaryTreeNode lft) {
        this.lft = lft;
    }

    public BinaryTreeNode getRgt() {
        return rgt;
    }

    public void setRgt(BinaryTreeNode rgt) {
        this.rgt = rgt;
    }
}
