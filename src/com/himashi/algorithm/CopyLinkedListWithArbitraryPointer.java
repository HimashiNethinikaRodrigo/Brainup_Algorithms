package com.himashi.algorithm;

import java.util.Hashtable;

public class CopyLinkedListWithArbitraryPointer {
    public static void main(String[] args) {
        Node start = new Node(7);
        start.next = new Node(14);
        start.next.next = new Node(21);

        start.arbitrary = start.next.next;
        start.next.next.arbitrary = start.next;

        Node clonedList = getDeepCopyLinkedList(start);

        testDeepCopyValidity(start, clonedList);

    }

    private static Node getDeepCopyLinkedList(Node start) {
        if (start == null)
            return null;
        Hashtable<Node, Node> hashtable = new Hashtable<>();
//        Create copy of the linked list without updating the arbitrary pointer
        Node newNodeHead = copyLinkedListWithoutUpdatingArbitrary(hashtable, start);
//        Update copy with correct arbitrary values
        linkedListCopy(hashtable, newNodeHead);

        return newNodeHead;
    }

    private static void linkedListCopy(Hashtable<Node, Node> hashtable, Node newNodeHead) {
        Node newCurrentNode = newNodeHead;

//        update arbitrary points
        while (newCurrentNode != null) {
            if (newCurrentNode.arbitrary != null) {
                newCurrentNode.arbitrary = hashtable.get(newCurrentNode.arbitrary);
            }
            newCurrentNode = newCurrentNode.next;
        }

    }

    private static Node copyLinkedListWithoutUpdatingArbitrary(Hashtable<Node, Node> hashtable, Node start) {
        Node startOldNode = start;
        Node newNodeHead = null;
        Node newPreviousNode = null;
        while (startOldNode != null){
            Node startNewNode = new Node(startOldNode.data);
            startNewNode.arbitrary = startOldNode.arbitrary;

            if(newPreviousNode != null)
                newPreviousNode.next = startNewNode;
            else
                newNodeHead = startNewNode;

            hashtable.put(startOldNode, startNewNode);
            newPreviousNode = startNewNode;
            startOldNode = startOldNode.next;

        }
        return newNodeHead;
    }

    private static void testDeepCopyValidity(Node start, Node clonedList) {
        //        Test address and data of head
        System.out.println("Address of original head: " + start );
        System.out.println("Address of cloned head: " + clonedList);
        System.out.println("Data of original head: " + start.data);
        System.out.println("Data of cloned head: " + clonedList.data);

//        Test address and data of next
        System.out.println("Address of original head: " + start.next );
        System.out.println("Address of cloned head: " + clonedList.next);
        System.out.println("Data of original head: " + start.next.data);
        System.out.println("Data of cloned head: " + clonedList.next.data);

//        Test address and data of next.next
        System.out.println("Address of original head: " + start.next.next );
        System.out.println("Address of cloned head: " + clonedList.next.next);
        System.out.println("Data of original head: " + start.next.next.data);
        System.out.println("Data of cloned head: " + clonedList.next.next.data);

        System.out.println("------------------------------------------------------------");

//        Test address and of arbitrary data of head
        System.out.println("Address of original head: " + start.arbitrary );
        System.out.println("Address of cloned head: " + clonedList.arbitrary);
        System.out.println("Data of original head: " + start.arbitrary.data);
        System.out.println("Data of cloned head: " + clonedList.arbitrary.data);

        //        Test address and of arbitrary data of next.next
        System.out.println("Address of original head: " + start.next.next.arbitrary );
        System.out.println("Address of cloned head: " + clonedList.next.next.arbitrary);
        System.out.println("Data of original head: " + start.next.next.arbitrary.data);
        System.out.println("Data of cloned head: " + clonedList.next.next.arbitrary.data);


    }

    static class Node{
        public int data;
        public Node next, arbitrary;
        public Node(int data){
            this.data = data;
            next = arbitrary = null;
        }
    }
}
