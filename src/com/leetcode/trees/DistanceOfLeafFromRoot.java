package com.leetcode.trees;

import java.util.List;

public class DistanceOfLeafFromRoot {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node4.left = node8;

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

      //  TreeNode x = new DistanceOfLeafFromRoot().countPairs(node1);
     //   System.out.println(x.list);
    }


}
