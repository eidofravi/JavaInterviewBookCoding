package com.cracking.LinkedList;

import com.cracking.Node;

public class FindKthToLast {

    // 2nd element from last , 20
    public static void main(String[] args) {
        Node node = new Node(10);
        node.addElement(new Node(20));
        node.addElement(new Node(40));
        node.addElement(new Node(20));
        node.addElement(new Node(60));
        node.addElement(new Node(70));
        Node first = node;
        Node second = node;
        for (int i = 0; i < 2; i++) {
            second = second.next;
        }
        while(second.next != null) {
            first = first.next;
            second = second.next;
        }
        System.out.println(first);
    }

}

