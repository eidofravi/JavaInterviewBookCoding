package com.cracking.LinkedList;

import com.cracking.Node;

public class ReverseList {

    // 2nd element from last , 20
    public static void main(String[] args) {
        Node node = new Node(10);
        node.addElement(new Node(20));
        node.addElement(new Node(30));
        node.addElement(new Node(40));
        node.addElement(new Node(50));
        node.addElement(new Node(60));
        Node current = node;
        Node head = null;
        while (current != null) {
            Node temp = current.next;
            current.next = head;
            head = current;
            current = temp;
        }
        System.out.println(head);

    }

}

