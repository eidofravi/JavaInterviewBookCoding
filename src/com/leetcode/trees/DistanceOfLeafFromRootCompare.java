package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class DistanceOfLeafFromRootCompare {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode node1 = new TreeNode(1, node2, node3);

        int x = new DistanceOfLeafFromRootCompare().countPairs(node1, 3);
        System.out.println(x);
    }

    int sum = 0;

    public int countPairs(TreeNode root, int distance) {
        traverseNode(root, distance);
        return sum;
    }

    private List<Integer> traverseNode(TreeNode root, int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        List<Integer> left = traverseNode(root.left, distance);
        List<Integer> right = traverseNode(root.right, distance);

        if (left.isEmpty() && right.isEmpty()) {
            list.add(1);
            return list;
        }
        if (!left.isEmpty() && !right.isEmpty()) {
            for (Integer l : left) {
                for (Integer r : right) {
                    if (l + r <= distance) sum++;
                }
            }
        }
        for (Integer l : left) {
            list.add(l + 1);
        }
        for (Integer r : right) {
            list.add(r + 1);
        }
        return list;
    }


}

