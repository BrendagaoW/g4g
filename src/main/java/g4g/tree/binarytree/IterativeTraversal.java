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

        System.out.println("\nPostOrder traversal (2 stack) of binary tree is - ");
        // except 4 5 2 3 1
        iterativeTraversal.postOrder(node1);

        System.out.println("\nPostOrder traversal (1 stack) of binary tree is - ");
        // except 4 5 2 3 1
        iterativeTraversal.postOrderOneStack(node1);
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

    private void postOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            BinaryTreeNode node = stack1.pop();
            stack2.push(node);
            if (node.getLft() != null) {
                stack1.push(node.getLft());
            }
            if (node.getRgt() != null) {
                stack1.push(node.getRgt());
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getValue() + " ");
        }
    }

    private void postOrderOneStack(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);

        BinaryTreeNode prev = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode curNode = stack.peek();
            // prev == null 是root节点的时候， prev.getLft() == curNode || prev.getRgt() == curNode意味着是从上往下在走，此时候，如果有左子，则入左子，若左子为空则入右子，若是叶子节点，则打印，出栈
            if (prev == null || prev.getLft() == curNode || prev.getRgt() == curNode) {
                if (curNode.getLft() != null) {
                    stack.push(curNode.getLft());
                } else if (curNode.getRgt() != null) {
                    stack.push(curNode.getRgt());
                } else {
                    // 叶子节点
                    System.out.print(curNode.getValue() + " ");
                    stack.pop();
                }
            } else if (prev == curNode.getLft()) {
                if (curNode.getRgt() == null) {
                    // 左子树遍历完毕，打印此节点
                    System.out.print(curNode.getValue() + " ");
                    stack.pop();
                } else {
                    // 左子树遍历完毕，但是还有右子树，将右子树入栈
                    stack.push(curNode.getRgt());
                }
            } else if (prev == curNode.getRgt()) {
                // 右子树遍历完毕，打印，出栈
                System.out.print(curNode.getValue() + " ");
                stack.pop();
            }
            prev = curNode;
        }
    }
}
