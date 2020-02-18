package com.cracking;

import java.util.HashSet;
import java.util.Set;

// A linked list node
class NodeListUtils {
    int data;
    NodeListUtils next;

    NodeListUtils(int data, NodeListUtils next) {
        this.data = data;
        this.next = next;
    }
};

public class LinkedListRemoveDuplicateData {
    // Helper function to print given linked list
    public static void printList(NodeListUtils head) {
        NodeListUtils ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    // Function to remove duplicates from a sorted list
    public static NodeListUtils removeDuplicates(NodeListUtils head) {
        NodeListUtils previous = null;
        NodeListUtils current = head;

        Set<Integer> set = new HashSet<>();
        // do till linked list is not empty
        while (current != null) {
            // if current node is seen before, delete it
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                // insert current node into the set and proceed to next node
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }

        return head;
    }

    // main method to remove remove duplicates from list
    public static void main(String[] args) {
        // input keys
        int[] keys = {5, 3, 4, 5, 1};

        // points to the head node of the linked list
        NodeListUtils head = null;

        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new NodeListUtils(keys[i], head);
        }

        removeDuplicates(head);

        // print linked list
        printList(head);
    }
}