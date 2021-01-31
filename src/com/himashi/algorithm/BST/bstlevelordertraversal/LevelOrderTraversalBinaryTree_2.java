package com.himashi.algorithm.BST.bstlevelordertraversal;

import com.himashi.algorithm.BST.BTUtil;
import com.himashi.algorithm.BST.Root;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Given the root of a binary tree,
 * display the node values at each level.
 * Node values for all levels should be displayed on separate lines.
 *          100
 *         /   \
 *       50     200
 *      /  \        \
 *   25   75         350
 *
 *   Level order traversal for this tree should look like:
 *   100;
 *   50, 200;
 *   25, 75, 350;
 *
 *   Runtime Complexity: O(n)
 *   Memory Complexity: O(n)
 *
 */

public class LevelOrderTraversalBinaryTree_2 {
    public static void main(String[] args) {
        Root root = BTUtil.getBST1();
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(Root root) {
        if (root == null)
            return;

        ArrayList<Queue<Root>> queues = new ArrayList<>();
        queues.add(new ArrayDeque<>());
        queues.add(new ArrayDeque<>());

        Queue<Root> currentQueue = queues.get(0);
        Queue<Root> nextQueue = queues.get(1);

        currentQueue.add(root);
        int levelNumber = 0;

        while (!currentQueue.isEmpty()){
            Root tempRoot = currentQueue.poll();
            if (currentQueue.isEmpty()) System.out.println(tempRoot.value + ";");
            else System.out.print(tempRoot.value + ", ");

            if (tempRoot.leftChild != null) nextQueue.add(tempRoot.leftChild);
            if (tempRoot.rightChild != null) nextQueue.add(tempRoot.rightChild);

            if (currentQueue.isEmpty()){
                levelNumber++;
                currentQueue = queues.get(levelNumber % 2);
                nextQueue = queues.get((levelNumber+1) % 2);
            }
        }
    }
}
