package com.cracking.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMethod {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add(5);
        queue.add(10);
        queue.add(15);
        queue.add(20);

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
