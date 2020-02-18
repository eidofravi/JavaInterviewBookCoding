package com.cracking.LinkedList;

import com.cracking.Node;

public class CheckPalindrome {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.addElement(new Node(20));
        node.addElement(new Node(30));
        node.addElement(new Node(40));
        node.addElement(new Node(30));
        node.addElement(new Node(30));
        node.addElement(new Node(10));
        boolean value = getNode(node, node, 8);
        System.out.println("value = " + value);
    }
x   
    public static boolean getNode(Node node, Node head, int count) {
        if (node.next == null) {
            return false;
        }
        count--;
        boolean value = getNode(node.next, head, count);
        Node temp = null;
        for(int i=0; i<count; i++) {
            temp = head;
            head = head.next;
        }
        if (node.data != temp.data) {
            value = true;
        }
        return value;
    }

}

