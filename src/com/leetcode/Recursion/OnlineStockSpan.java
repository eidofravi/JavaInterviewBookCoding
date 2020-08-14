package com.leetcode.Recursion;

import java.util.HashMap;
import java.util.Map;

// 901 leetcode
public class OnlineStockSpan {
    public static void main(String[] args) {
        int price = 0;
        Integer[][] stockdata = {{}, {100}, {80}, {60}, {70}, {60}, {75}, {85}};

        new OnlineStockSpan().nextHelper(stockdata);
    }

    Map<Integer, Integer> map = new HashMap<>();

    Integer[] newRecord = null;

    public void nextHelper(Integer[][] stockdata) {
        Integer finalArr[] = new Integer[stockdata.length];
        newRecord = new Integer[stockdata.length - 1];
        int start = 1;
        int index = 0;
        for (Integer[] stock : stockdata) {
            if (stock.length > 0) {
                map.put(stock[0], index);
                newRecord[index] = stock[0];
                index++;
            }
        }
        for (int val : newRecord) {
            int value = next(val);
            finalArr[start++] = value;
        }
    }

    public Integer next(Integer price) {
        if (price == null) {
            return null;
        }
        int count = 0;
        int currInd = map.get(price);
        while (currInd >= 0) {
            int value = newRecord[currInd--];
            if (value <= price) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}



