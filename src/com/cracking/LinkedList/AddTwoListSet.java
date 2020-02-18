package com.cracking.LinkedList;

import com.cracking.Node;

public class AddTwoListSet {
    public static void main(String[] args) {
        Node node1 = new Node(3);
        node1.addElement(new Node(2));
        node1.addElement(new Node(1));

        Node node2 = new Node(6);
        node2.addElement(new Node(5));
        node2.addElement(new Node(4));

        double node1Sum = 0;
        double count = 0;
        while (node1 != null) {
            node1Sum = node1Sum + node1.data * Math.pow(10L, count++);
            node1 = node1.next;
        }
        int finalsumNode1 = (int) node1Sum;

        double node2Sum = 0;
        count = 0;
        while (node2 != null) {
            node2Sum = node2Sum + node2.data * Math.pow(10L, count++);
            node2 = node2.next;
        }
        int finalsumNode2 = (int) node2Sum;
        int finalSum = finalsumNode1 + finalsumNode2;
        System.out.println(finalSum);
        Node newNode = null;
        while (finalSum != 0) {
            int num = finalSum % 10;
            if (null == newNode) {
                newNode = new Node(num);
            } else {
                newNode.addElement(new Node(num));
            }
            finalSum = finalSum / 10;
        }
        System.out.println(finalSum);


    }
}
