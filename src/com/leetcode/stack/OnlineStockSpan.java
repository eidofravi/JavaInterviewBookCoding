package com.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 901 leetcode
public class OnlineStockSpan {
    static int index = -1;
    static Stack<Item> stack = new Stack<>();

    public static void main(String[] args) {
        int[][] stockdata = {{100}, {75}, {60}, {70}, {60}, {75}, {85}};
        for (int price[] : stockdata) {
            index++;
            System.out.println(new OnlineStockSpan().next(price[0]));
        }
    }


    public int next(int price) {
        int position = 0;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            stack.push(new Item(price, index));
            return index + 1;
        }
        position  =  index - stack.peek().index;
        stack.push(new Item(price, index));
        return position;

    }
}

class Item {
    int price;
    int index;

    Item(int price, int index) {
        this.price = price;
        this.index = index;
    }
}



