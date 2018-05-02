package g4g.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        System.out.println("\nLevel order traversal (line by line with 1 queue and count) of binary tree is - ");
        bft.breadthFirstTraversalLineByLine1QueueAndCount(node1);

        System.out.println("\nLevel order traversal (line by line with delimiter) of binary tree is - ");
        bft.breadthFirstTraversalLineByLineWithDelimiter(node1);

        System.out.println("\nReverse Level order traversal (line by line with delimiter) of binary tree is - ");
        // expect 4 5 2 3 1
        bft.breadthFirstTraversalReverse(node1);
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
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
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

    // Print line by line, Using 1 queues
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree
    private void breadthFirstTraversalLineByLine1QueueAndCount(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        BinaryTreeNode curNode;
        int currentLevelCount;
        int nextLevelCount = 1;
        while (!queue.isEmpty()) {
            currentLevelCount = nextLevelCount;
            nextLevelCount = 0;
            for (int i=0; i<currentLevelCount; ++i) {
                curNode = queue.poll();
                System.out.print(curNode.getValue() + " ");
                if (curNode.getLft() != null) {
                    queue.offer(curNode.getLft());
                    nextLevelCount++;
                }
                if (curNode.getRgt() != null) {
                    queue.offer(curNode.getRgt());
                    nextLevelCount++;
                }
            }
            System.out.println();
        }
    }

    // Print line by line, Using 1 queues
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree
    private void breadthFirstTraversalLineByLineWithDelimiter(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        // offer root and null as initialization
        queue.offer(root);
        queue.offer(null);

        BinaryTreeNode curNode;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            if (curNode == null) {
                // need to check if queue is empty now
                if (!queue.isEmpty()) {
                    System.out.println();
                    queue.offer(null);
                }
                // 此处没必要写else，是因为如果queue.isEmpty() 了，那么在下个循环的时候就会自动退出
            } else {
                System.out.print(curNode.getValue() + " ");
                if (curNode.getLft() != null) {
                    queue.offer(curNode.getLft());
                }
                if (curNode.getRgt() != null) {
                    queue.offer(curNode.getRgt());
                }
            }
        }
    }

    private void breadthFirstTraversalReverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        queue.offer(root);
        BinaryTreeNode curNode;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            stack.push(curNode);
            if (curNode.getRgt() != null) {
                queue.offer(curNode.getRgt());
            }
            if (curNode.getLft() != null) {
                queue.offer(curNode.getLft());
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getValue() + " ");
        }
    }


}
