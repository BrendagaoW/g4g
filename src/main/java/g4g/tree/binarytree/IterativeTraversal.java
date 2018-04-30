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
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        IterativeTraversal iterativeTraversal = new IterativeTraversal();

        System.out.println("\nPreOrder traversal of binary tree is - ");
        // except 1 2 4 5 3
        iterativeTraversal.preOrder(node1);

        System.out.println("\nInOrder traversal of binary tree is - ");
        // except 4 2 5 1 3
        iterativeTraversal.inOrder(node1);
    }


    private void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);

        BinaryTreeNode curNode;

        // 不能写成 while((curNode = stack.pop()) != null) 因为如果栈空的话，pop方法是throw EmptyStackException rather than return null
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            System.out.print(curNode.getValue() + " ");
            if (curNode.getRgt() != null) {
                stack.push(curNode.getRgt());
            }
            if (curNode.getLft() != null) {
                stack.push(curNode.getLft());
            }
        }
    }


    /**
     *
     * reference: https://www.youtube.com/watch?v=nzmtCFNae9k
     */
    private void inOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode curNode = root;
        while (true) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.getLft();
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    curNode = stack.pop();
                    System.out.print(curNode.getValue() + " ");
                    curNode = curNode.getRgt();
                }
            }
        }
    }
}
