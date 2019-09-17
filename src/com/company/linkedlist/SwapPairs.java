package com.company.linkedlist;

/**
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SwapPairs {

    public static void main(String[] args) {

        ListNode head = ListNode.build(new int[]{1, 2, 3, 4});

        ListNode h = swapPairs(head);
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) {
            //只有两个节点
            ListNode h = head.next;
            h.next = head;
            head.next = null;
            return h;
        }
        //至少有三个节点

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        head = next;

        while(next != null) {
            //交换
            ListNode temp = next.next;
            next.next = cur;
            cur.next = temp;
            if (prev != null) prev.next = next;

            prev = cur;
            cur = temp;
            if (cur != null) next = cur.next;
            else next = null;
        }

        return head;
    }
}
