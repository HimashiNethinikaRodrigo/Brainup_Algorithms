package com.himashi.algorithm.linkedList;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val)
                return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }

        return reverse;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
}
