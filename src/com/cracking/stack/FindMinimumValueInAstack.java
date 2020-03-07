package com.cracking.stack;

public class FindMinimumValueInAstack {

    public static void main(String[] args) {
        FindMinimumValueInAstack stack = new FindMinimumValueInAstack();
        stack.push(new FindMinimumValueInAstack.Node(5));
        stack.push(new FindMinimumValueInAstack.Node(6));
        stack.push(new FindMinimumValueInAstack.Node(3));
        stack.push(new FindMinimumValueInAstack.Node(7));
        System.out.println(stack.findMinimum());
        stack.pop();
        stack.pop();
        System.out.println(stack.findMinimum());
    }

    private static class Node {
        Node next = null;
        int data;
        Integer minValue;
        public Node(int data) {
            this.data = data;
        }
    }
    public Node top = null;
    public Integer min = null;

    public void push(Node node) {
        node.next = top;
        top = node;
        if (null == min) {
            min = node.data;
            node.minValue = node.data;
        } else if (node.data < min) {
            min = node.data;
            node.minValue = node.data;
        } else {
            node.minValue = min;
        }
    }

    public int findMinimum() {
        return top.minValue;
    }

    public Node pop() {
        Node temp = top;
        top = top.next;
        return temp;
    }

}
