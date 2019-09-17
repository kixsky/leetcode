package com.company.linkedlist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class DeleteDuplicates {

  public static void main(String[] args) {

  }


  public ListNode deleteDuplicates(ListNode head) {

    ListNode h = head;

    //边界
    if (h == null) return null;

    Set<Integer> set = new HashSet<>();
    Queue<ListNode> q = new LinkedList<>();
    while(h != null) {
      if (!set.contains(h.val)) {
        set.add(h.val);
        q.add(h);
      }
      h = h.next;
    }

    //如果队列为空
    if (q.isEmpty()) return null;

    //重组链表
    ListNode h1 = q.poll();
    head = h1;
    while(!q.isEmpty()) {
      h = q.poll();
      h1.next = h;
      h1 = h;
    }
    h1.next = null; //重组链表总是忘记这个
    return head;
  }
}
