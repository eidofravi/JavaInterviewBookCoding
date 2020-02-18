package com.cracking.queue;

public class MyQueue {
    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue();
        customQueue.push(new CustomQueue.Node(20));
        customQueue.push(new CustomQueue.Node(30));
        customQueue.push(new CustomQueue.Node(40));
        customQueue.push(new CustomQueue.Node(50));
        System.out.println(customQueue.pop());
    }

}


class CustomQueue {

    private Node first = null;
    private Node last = null;
    public static class Node {
        public Node next;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }
    public void push(Node node) {
        Node temp = last;
        node.next = temp;
        last = node;
    }

    public Node pop() {
        if (null != first) {
            while (null != first.next && first.next != last) {
                first = first.next;
            }
            Node secondLast = first;
            secondLast.next = null;
        }
        return last;
    }



}
