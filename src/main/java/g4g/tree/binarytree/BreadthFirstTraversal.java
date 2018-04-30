package g4g.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

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

        BreadthFirstTraversal bft = new BreadthFirstTraversal();
        System.out.println("\nLevel order traversal of binary tree is - ");
        // expect 1 2 3 4 5
        bft.breadthFirstTraversal(node1);

        System.out.println("\nLevel order traversal (line by line with 2 queues) of binary tree is - ");
        bft.breadthFirstTraversalLineByLine2Queues(node1);

        System.out.println("\nLevel order traversal (line by line with 1 queue) of binary tree is - ");
        bft.breadthFirstTraversalLineByLine1Queue(node1);
    }


    // ====================================================================================================

    // Print All, Use Queue
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree
    private void breadthFirstTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        BinaryTreeNode curNode;
        while ((curNode = queue.poll()) != null) {
            System.out.print(curNode.getValue() + " ");
            if (curNode.getLft() != null) {
                queue.offer(curNode.getLft());
            }
            if (curNode.getRgt() != null) {
                queue.offer(curNode.getRgt());
            }
        }
    }

    // ====================================================================================================
    // Print line by line, Using 2 queues
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree

    private void breadthFirstTraversalLineByLine2Queues(BinaryTreeNode root) {

        Queue<BinaryTreeNode> queue1 = new LinkedList<BinaryTreeNode>();
        Queue<BinaryTreeNode> queue2 = new LinkedList<BinaryTreeNode>();

        queue1.offer(root);
        BinaryTreeNode curNode;

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while ((curNode = queue1.poll()) != null) {
                System.out.print(curNode.getValue() + " ");
                if (curNode.getLft() != null) {
                    queue2.offer(curNode.getLft());
                }
                if (curNode.getRgt() != null) {
                    queue2.offer(curNode.getRgt());
                }
            }
            System.out.println();
            while ((curNode = queue2.poll()) != null) {
                System.out.print(curNode.getValue() + " ");
                if (curNode.getLft() != null) {
                    queue1.offer(curNode.getLft());
                }
                if (curNode.getRgt() != null) {
                    queue1.offer(curNode.getRgt());
                }
            }
            System.out.println();
        }
    }

    // Print line by line, Using 1 queues
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree
    private void breadthFirstTraversalLineByLine1Queue(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        if (root == null) {
            return;
        }
        queue.offer(root);
        BinaryTreeNode curNode;

        while (!queue.isEmpty()) {
            int lineSize = queue.size();
            for (int i=0; i<lineSize; ++i) {
                curNode = queue.poll();
                System.out.print(curNode.getValue() + " ");
                if (curNode.getLft() != null) {
                    queue.offer(curNode.getLft());
                }
                if (curNode.getRgt() != null) {
                    queue.offer(curNode.getRgt());
                }
            }
            System.out.println();
        }
    }


}
