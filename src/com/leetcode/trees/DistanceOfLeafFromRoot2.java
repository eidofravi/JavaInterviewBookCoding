package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class DistanceOfLeafFromRoot2 {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode node1 = new TreeNode(1, node2, node3);

        int x = new DistanceOfLeafFromRoot2().countPairs(node1, 3);
        System.out.println(x);
    }

    int count = 0;

    private int countPairs(TreeNode node, int distance) {
        traverseNode(node, distance);
        return count;
    }

    private List<Integer> traverseNode(TreeNode node, int distance) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        List<Integer> left = traverseNode(node.left, distance);
        List<Integer> right = traverseNode(node.right, distance);

        if (left.isEmpty() && right.isEmpty()) {
            list.add(1);
            return list;
        }
        if (!left.isEmpty() && !right.isEmpty()) {
            for (int l : left) {
                for (int r : right) {
                    if (l + r <= distance) {
                        count++;
                    }
                }
            }
        }
        if (!left.isEmpty()) {
            for (int l : left) {
                list.add(l + 1);
            }
        }
        if (!right.isEmpty()) {
            for (Integer r : right) {
                list.add(r + 1);
            }
        }
        return list;
    }
}
