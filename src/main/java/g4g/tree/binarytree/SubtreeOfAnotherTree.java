package g4g.tree.binarytree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode: https://leetcode.com/problems/subtree-of-another-tree/description/
 */
public class SubtreeOfAnotherTree {

    // 两种思路，一个是recursive遍历去查，一个是iterative遍历去查

    public static boolean isSubtreeRecursive(BinaryTreeNode s, BinaryTreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtreeRecursive(s.getLft(), t) || isSubtreeRecursive(s.getRgt(), t);
    }


    // 思路： 广度优先遍历
    public static boolean isSubtreeIterative(BinaryTreeNode s, BinaryTreeNode t) {
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(s);
        BinaryTreeNode curNode;
        while ((curNode = queue.poll()) != null) {
            if (isSameTree(curNode, t)) {
                return true;
            }
            if (curNode.getLft() != null) {
                queue.offer(curNode.getLft());
            }
            if (curNode.getRgt() != null) {
                queue.offer(curNode.getRgt());
            }
        }
        return false;
    }


    public static boolean isSameTree(BinaryTreeNode s, BinaryTreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            return (s.getValue() == t.getValue()) && isSameTree(s.getLft(), t.getLft()) && isSameTree(s.getRgt(), t.getRgt());
        }
    }

}
