package g4g.tree.binarytree;

import java.util.Stack;

public class IterativeTraversal {

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

        IterativeTraversal iterativeTraversal = new IterativeTraversal();

        System.out.println("\nPreOrder traversal of binary tree is - ");
        // except 1 2 4 5 3
        iterativeTraversal.preOrder(node1);

        System.out.println("\nInOrder traversal of binary tree is - ");
        // except 4 2 5 1 3
        iterativeTraversal.inOrder(node1);

        System.out.println("\nPostOrder traversal (2 stack) of binary tree is - ");
        // except 4 5 2 3 1
        iterativeTraversal.postOrder(node1);

        System.out.println("\nPostOrder traversal (1 stack) of binary tree is - ");
        // except 4 5 2 3 1
        iterativeTraversal.postOrderOneStack(node1);
    }


    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode curNode;

        // 不能写成 while((curNode = stack.pop()) != null) 因为如果栈空的话，pop方法是throw EmptyStackException rather than return null
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            System.out.print(curNode.val + " ");
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }


    /**
     *
     * reference: https://www.youtube.com/watch?v=nzmtCFNae9k
     */
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = root;
        while (true) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    curNode = stack.pop();
                    System.out.print(curNode.val + " ");
                    //  此处只需将cur移动到右子，下次循环是会进行入栈操作
                    curNode = curNode.right;
                }
            }
        }
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    private void postOrderOneStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.peek();
            // prev == null 是root节点的时候， prev.getLft() == curNode || prev.getRgt() == curNode意味着是从上往下在走，此时候，如果有左子，则入左子，若左子为空则入右子，若是叶子节点，则打印，出栈
            if (prev == null || prev.left == curNode || prev.right == curNode) {
                if (curNode.left != null) {
                    stack.push(curNode.left);
                } else if (curNode.right != null) {
                    stack.push(curNode.right);
                } else {
                    // 叶子节点
                    System.out.print(curNode.val + " ");
                    stack.pop();
                }
            } else if (prev == curNode.left) {
                if (curNode.right == null) {
                    // 左子树遍历完毕, 右子树为空，打印此节点，出栈
                    System.out.print(curNode.val + " ");
                    stack.pop();
                } else {
                    // 左子树遍历完毕，但是还有右子树，将右子树入栈
                    stack.push(curNode.right);
                }
            } else if (prev == curNode.right) {
                // 右子树遍历完毕，打印，出栈
                System.out.print(curNode.val + " ");
                stack.pop();
            }
            prev = curNode;
        }
    }
}
