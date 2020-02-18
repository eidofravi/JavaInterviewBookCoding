package com.cracking;

public class LinkedListChangeElementValue {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.addElement(new Node(20));
        node.addElement(new Node(40));
        node.addElement(new Node(20));
        node.addElement(new Node(60));
        Node head = node;
        for (int i=1; i<3; i++) {
            node = node.next;
        }
        node.data = 400;
        System.out.println(head);

    }


}

