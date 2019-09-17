package com.company.linkedlist;

import java.util.List;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

    public static ListNode build(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode h = head;
        for (int i = 1; i < nums.length; i++) {
            h.next = new ListNode(nums[i]);
            h = h.next;
        }
        return head;
    }
}
