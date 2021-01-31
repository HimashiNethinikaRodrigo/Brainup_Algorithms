package com.himashi.algorithm.BST;

import java.util.LinkedList;

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
