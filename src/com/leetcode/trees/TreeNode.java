package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
   // public List<Node> list = new ArrayList<>();

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
               // ", list=" + list +
                '}';
    }
}

class Node {
    public int left;
    public int right;

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
