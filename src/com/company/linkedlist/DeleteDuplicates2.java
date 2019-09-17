package com.company.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class DeleteDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Queue<ListNode> q = new LinkedList<>();
        ListNode h = head;
        Map<Integer, Integer> countMap = new HashMap<>();
        while(h != null) {
            Integer count = countMap.get(h.val);
            if (count == null) {
                countMap.put(h.val, 1);
            } else
                countMap.put(h.val, ++count);
            q.add(h);
            h = h.next;
        }

        h = head = new ListNode(0);

        while (!q.isEmpty()) {
            ListNode temp = q.poll();
            int count = countMap.get(temp.val);
            if (count == 1) {
                h.next = temp;
                h = h.next;
            }
        }
        h.next = null;
        return head.next;
    }
}
