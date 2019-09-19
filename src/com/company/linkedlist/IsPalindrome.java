package com.company.linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    ListNode h = head;
    h.next = new ListNode(2);

    h = h.next;
    h.next = new ListNode(2);

    h = h.next;
    h.next = new ListNode(1);


    System.out.println(isPalindrome(head));
  }


  public static boolean isPalindrome(ListNode head) {
    ListNode h = head;
    if (h == null) return true;

    Stack<ListNode> stack = new Stack<>();
    while(h != null) {
      stack.push(h);
      h = h.next;
    }

    h = head;
    while(h != null) {
      ListNode n = stack.pop();
      if (n.val != h.val) return false;
      h = h.next;
    }

    return true;
  }

}
