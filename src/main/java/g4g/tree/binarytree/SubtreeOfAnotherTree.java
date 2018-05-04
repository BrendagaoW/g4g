package g4g.tree.binarytree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode: https://leetcode.com/problems/subtree-of-another-tree/description/
 */
public class SubtreeOfAnotherTree {

    // 两种思路，一个是recursive遍历去查，一个是iterative遍历去查

    public static boolean isSubtreeRecursive(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtreeRecursive(s.left, t) || isSubtreeRecursive(s.right, t);
    }


    // 思路： 广度优先遍历
    public static boolean isSubtreeIterative(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);
        TreeNode curNode;
        while ((curNode = queue.poll()) != null) {
            if (isSameTree(curNode, t)) {
                return true;
            }
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        return false;
    }


    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            return (s.val == t.val) && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }

}
