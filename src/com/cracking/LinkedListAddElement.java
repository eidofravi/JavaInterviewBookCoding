package com.cracking;

import java.util.HashSet;
import java.util.Set;

public class LinkedListAddElement {

    public static void main(String[] args) {
        Node node = new Node(10);
        addElement(node, new Node(20));
        addElement(node, new Node(40));
        addElement(node, new Node(20));
        addElement(node, new Node(60));
        System.out.println(node);

    }

    public static void addElement(Node node, Node newElement) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = newElement;
    }
}

