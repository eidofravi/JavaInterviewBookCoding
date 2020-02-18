package com.cracking;

public class Node {
    public int data;
    public Node next;
    public boolean notPalidrome = false;
    public Node(int data) {
        this.data = data;
    }
    public Node() {
    }
    public void addElement(Node newElement) {
        Node node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newElement;
    }
}
