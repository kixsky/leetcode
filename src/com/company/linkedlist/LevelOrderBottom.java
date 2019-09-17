package com.company.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LevelOrderBottom {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> list = new ArrayList<>();
    if (root == null) return list;

    TreeNode h = root;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(h);

    List<Integer> l = null;

    int parentSize = 1, childSize = 0;

    while(!q.isEmpty()) {
      h = q.poll();
      if (l == null) {
        l = new ArrayList<>();
      }
      l.add(h.val);

      if (h.left != null) {
        q.add(h.left);   //左子树入栈
        childSize++;
      }
      if (h.right != null) {
        q.add(h.right); //右子树入栈
        childSize++;
      }

      parentSize--;
      if (parentSize == 0) {
        parentSize = childSize;
        childSize = 0;
        list.add(l);
        l = new ArrayList<>();
      }
    }

    List<List<Integer>> newList = new ArrayList<>();
    for (int i = list.size() - 1; i >= 0; i++) {
      newList.add(list.get(i));
    }

    return newList;
  }
}
