package com.just.learn.algorithem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {

    /**
     * 第125题 是否是回文
     * @param "A man, a plan, a canal: Panama"
     * @return
     */
    public static boolean isPalindrome(String param) {
        //先替换会影响效率
        param = param.toLowerCase().replaceAll("[^0-9a-z]", "");
        char[] c = param.toCharArray();
        int i =0;
        int j = c.length - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 二叉树最大深度-递归
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 二叉树最大深度-栈
     * dfs 需要辅助队列层级
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //stack与level同时入栈出栈 stack是元素节点，level 是记录节点在第几层
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        //尾部
        stack.add(root);
        //头部
        level.push(1);
        int max = 0;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            int temp = level.pop();
            max = Math.max(temp, max);
            if (node.right != null) {
                stack.push(node.right);
                level.push(temp + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                level.push(temp + 1);
            }
        }
        return max;
    }

    /**
     * 队列 bfs 队列自带层级
     * @param root
     * @return
     */
    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //offer有界队列时等同于add
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                //第一个元素
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size = size - 1;
            }
            ans++;
        }
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(maxDepth2(root));
        System.out.println(maxDepth3(root));
    }

}
