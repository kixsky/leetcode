package com.company.tree;

import java.util.Stack;

/**
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *  
 *
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FindTarget {


  public boolean findTarget(TreeNode root, int k) {
    if (root == null) return false;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
      TreeNode h = stack.pop();
      TreeNode temp = find(root, k - h.val);
      if (temp != null && h != temp) return true;
      if (h.left != null) stack.push(h.left);
      if (h.right != null) stack.push(h.right);
    }
    return false;
  }


  private TreeNode find(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;
    if (root.val > val) return find(root.left, val);
    else return find(root.right, val);
  }

}
