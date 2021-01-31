package com.himashi.algorithm.BST.bstlevelordertraversal;

import com.himashi.algorithm.BST.BTUtil;
import com.himashi.algorithm.BST.Root;

import java.util.*;

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
 *   100
 *   50, 200
 *   25, 75, 350
 *
 *   Time Complexity: O(n)
 *
 */

public class LevelOrderTraversalBinaryTree_1 {

    public static void main(String[] args) {
        Root root = BTUtil.getBST1();
        if (root == null)
            System.out.println("Empty Binary Tree");
        else {
            int val = 1;
            Hashtable<Integer, List<Integer>> map = new Hashtable<>();
            levelOrderTraversal(root, val, map);
            map.forEach((key, value) -> System.out.println(value));
        }

    }

    private static void levelOrderTraversal(Root root, int key, Hashtable<Integer, List<Integer>> map) {
        if (map.containsKey(key)) map.get(key).add(root.value);
        else map.put(key, new ArrayList<>(Collections.singletonList(root.value)));

        if (root.leftChild == null && root.rightChild == null)
            return;
        if (root.leftChild != null) levelOrderTraversal(root.leftChild, key+1, map);
        if (root.rightChild != null) levelOrderTraversal(root.rightChild, key+1, map);
    }


}
