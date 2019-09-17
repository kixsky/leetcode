package com.company.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

  public List<List<Integer>> levelOrder(TreeNode root) {
    TreeNode h = root;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(h);

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> l = null;

    int parentSize = 1, childSize = 0;

    while(!q.isEmpty()) {
      h = q.poll();
      if (l == null) {
        l = new ArrayList<>();
      }

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
    return list;
  }
}
