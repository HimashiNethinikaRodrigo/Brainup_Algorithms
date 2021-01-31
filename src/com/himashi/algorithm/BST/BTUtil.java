package com.himashi.algorithm.BST;

public class BTUtil {
    public static Root getBST1(){
        Root root = new Root(100);
        root.leftChild = new Root(50);
        root.rightChild = new Root(200);
        root.leftChild.leftChild = new Root(25);
        root.leftChild.rightChild = new Root(75);
        root.rightChild.rightChild = new Root(350);
        return root;
    }
    public static Root getBST2(){
        Root root = new Root(100);
        root.leftChild = new Root(50);
        root.rightChild = new Root(200);
        root.leftChild.leftChild = new Root(25);
        root.leftChild.rightChild = new Root(75);
        root.rightChild.leftChild = new Root(125);
        root.rightChild.rightChild = new Root(350);
        return root;
    }
    public static Root getBSTInvalid(){
        Root root = new Root(100);
        root.leftChild = new Root(50);
        root.rightChild = new Root(200);
        root.leftChild.leftChild = new Root(25);
        root.leftChild.rightChild = new Root(75);
        root.rightChild.leftChild = new Root(90);
        root.rightChild.rightChild = new Root(350);
        return root;
    }
}
