package com.cracking.tree;

import java.util.Stack;

// iterative approach is done through stack
public class PreOrderReversalIterative {

    public static void main(String[] args) {
        Node node40 = new Node(40);
        Node node20 = new Node(20);
        Node node60 = new Node(60);
        Node node10 = new Node(10);
        Node node30 = new Node(30);
        Node node50 = new Node(50);
        Node node70 = new Node(70);
        node40.left = node20;
        node40.right = node60;
        node20.left = node10;
        node20.right = node30;
        node60.left = node50;
        node60.right = node70;
        Stack<Node> stack = new Stack();
        stack.push(node40);
        while(!stack.isEmpty()) {
            Node head = stack.pop();
            System.out.println(head.data);
            if (null != head.right){
                stack.push(head.right);
            }
            if (null != head.left) {
                stack.push(head.left);
            }
        }



    }



    private static class Node {
        public Node left;
        public Node right;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }
}
