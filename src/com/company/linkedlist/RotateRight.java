package com.company.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class RotateRight {


    public static void main(String[] args) {
        ListNode head = ListNode.build(new int[]{1, 2,3,4, 5});
        new RotateRight().rotateRight(head, 2);
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int size = size(head);
        if (k % size == 0) return head;
        int zeroIndex = size - (k % size);
        ListNode zeroNode = index(head, zeroIndex);
        ListNode prev = prev(head, zeroNode);
        prev.next = null;
        ListNode h = zeroNode;
        while(h.next != null) {
            h = h.next;
        }
        h.next = head;
        return zeroNode;
    }


    private ListNode index(ListNode h, int index) {
        int count = 0;
        while(h != null) {
            if (count == index) return h;
            h = h.next;
            count++;
        }
        return null;
    }

    private int size(ListNode h) {
        int size = 0;
        while (h != null) {
            h = h.next;
            size++;
        }
        return size;
    }

    private ListNode prev(ListNode head, ListNode h) {
        if (head == null) return null;
        if (h == null) return null;
        if (head == h) return null;
        while(head.next != h) {
            head = head.next;
        }
        return head;
    }
}
