package com.company.linkedlist;

import java.util.Stack;

public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int index = getSize(head) - n;
        int i = 0;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            if (i == index) break;
            prev = cur;
            cur = cur.next;
            i++;
        }
        if (prev == null) return cur.next;
        prev.next = cur.next;
        return head;
    }


    private int getSize(ListNode h) {
        int size = 0;
        while(h != null) {
            h = h.next;
            size++;
        }
        return size;
    }
}
