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
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);

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
    private void breadthFirstTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode curNode;
        while ((curNode = queue.poll()) != null) {
            System.out.print(curNode.val + " ");
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
    }

    // ====================================================================================================
    // Print line by line, Using 2 queues
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree

    private void breadthFirstTraversalLineByLine2Queues(TreeNode root) {

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();

        queue1.offer(root);
        TreeNode curNode;

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while ((curNode = queue1.poll()) != null) {
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue2.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue2.offer(curNode.right);
                }
            }
            System.out.println();
            while ((curNode = queue2.poll()) != null) {
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue1.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue1.offer(curNode.right);
                }
            }
            System.out.println();
        }
    }

    // Print line by line, Using 1 queues
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree
    private void breadthFirstTraversalLineByLine1Queue(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode curNode;

        while (!queue.isEmpty()) {
            int lineSize = queue.size();
            for (int i=0; i<lineSize; ++i) {
                curNode = queue.poll();
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            System.out.println();
        }
    }

    // Print line by line, Using 1 queues
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree
    private void breadthFirstTraversalLineByLine1QueueAndCount(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode curNode;
        int currentLevelCount;
        int nextLevelCount = 1;
        while (!queue.isEmpty()) {
            currentLevelCount = nextLevelCount;
            nextLevelCount = 0;
            for (int i=0; i<currentLevelCount; ++i) {
                curNode = queue.poll();
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    nextLevelCount++;
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    nextLevelCount++;
                }
            }
            System.out.println();
        }
    }

    // Print line by line, Using 1 queues
    // Time: O(n)
    // Space: O(w) where w is maximum width of Binary Tree
    private void breadthFirstTraversalLineByLineWithDelimiter(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // offer root and null as initialization
        queue.offer(root);
        queue.offer(null);

        TreeNode curNode;
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
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
    }

    private void breadthFirstTraversalReverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        queue.offer(root);
        TreeNode curNode;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            stack.push(curNode);
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
    }


}
