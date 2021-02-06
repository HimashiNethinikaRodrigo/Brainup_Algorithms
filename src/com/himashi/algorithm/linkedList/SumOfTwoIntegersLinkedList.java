package com.himashi.algorithm.linkedList;

public class SumOfTwoIntegersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0);
        ListNode tempNode = resultList;
        int valueFromPrevAddition = 0;
        while (l1 != null || l2 != null) {
            int x = l1!= null ? l1.val : 0;
            int y = l2!= null ? l2.val : 0;

            int sum = valueFromPrevAddition + x + y;
            valueFromPrevAddition = sum / 10;
            tempNode.next = new ListNode(sum % 10);
            tempNode  = tempNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            if (valueFromPrevAddition > 0) {
                tempNode.next = new ListNode(valueFromPrevAddition);
            }
        }

        return resultList.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
