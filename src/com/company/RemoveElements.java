package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 思路： 使用队列的先进先出性质，过滤掉val
 *
 */
public class RemoveElements {

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    ListNode h = head;
    h.next = new ListNode(2);
    //h = h.next;
    //h.next = new ListNode(6);
    //h = h.next;
    //h.next = new ListNode(3);
    //
    //h = h.next;
    //h.next = new ListNode(4);
    //
    //h = h.next;
    //h.next = new ListNode(5);
    //
    //h = h.next;
    //h.next = new ListNode(6);


    head = removeElements(head, 1);
    System.out.println(head.val);
  }


  public static ListNode removeElements(ListNode head, int val) {

    if (head == null) return null;

    Queue<ListNode> q = new LinkedList<>();
    ListNode h = head;
    while(h.next != null) {
      if (h.val != val)
        q.add(h);
      h = h.next;
    }

    if (h.val != val)
      q.add(h);

    if (q.isEmpty()) return null;

    ListNode h1 = q.poll();
    head = h1;
    while(!q.isEmpty()) {
      h = q.poll();
      h1.next = h;
      h1 = h;
    }

    return head;
  }


  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }


}
