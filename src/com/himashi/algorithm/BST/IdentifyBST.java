package com.himashi.algorithm.BST;

/**
 * Given a Binary Tree, figure out whether it’s a Binary Search Tree. In a binary search tree,
 * each node’s key value is smaller than the key value of all nodes in the right subtree,
 * and is greater than the key values of all nodes in the left subtree.
 * Below is an example of a binary tree that is a valid BST.
 *
 *       100
 *      /   \
 *    50     200
 *   /  \    /  \
 *25   75  125   350
 *
 * An example of a binary tree that is not a BST.
 *       100
 *      /   \
 *    50     200
 *   /  \    /  \
 *25   75  90   350
 *
 * Time Complexity: O(n)
 * Memory Complexity: O(n)
 */

public class IdentifyBST {
    public static void main(String[] args) {
        Root rootWithInvalidBST = BTUtil.getBSTInvalid();
        Root rootWithValidBST = BTUtil.getBST2();

        System.out.println(isValidBST(rootWithInvalidBST, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isValidBST(rootWithValidBST, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    private static boolean isValidBST(Root root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max) return false;

        return isValidBST(root.leftChild, min, root.value)
                && isValidBST(root.rightChild, root.value, max);
    }
}
