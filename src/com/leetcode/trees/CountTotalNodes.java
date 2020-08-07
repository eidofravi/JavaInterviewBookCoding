package com.leetcode.trees;

public class CountTotalNodes {
    int sum = 0;

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        //TreeNode node8 = new TreeNode(8);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode node1 = new TreeNode(1, node2, node3);

         new CountTotalNodes().sumOfNodesHelper(node1);



    }

    private void sumOfNodesHelper(TreeNode root) {
        int returnVal = sumOfNodes(root);
        System.out.println(returnVal);
    }

    private int sumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftReturn = sumOfNodes(root.left);
        int rightReturn = sumOfNodes(root.right);

        if (leftReturn  + rightReturn > 1) {
            return leftReturn  + rightReturn + 1;
        }

        return 1;
    }
}
