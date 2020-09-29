package com.leetcode.createclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCalendarII {

    // ["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book"]
    //        [[],[],[],[],[],[],[],[],[],[],[]]

    public static void main(String[] args) {
        MyCalendarII obj = new MyCalendarII();
        System.out.println(obj.book(24, 40));
        System.out.println(obj.book(43,50));
        System.out.println(obj.book(27,43));
        System.out.println(obj.book(5,21));
        System.out.println(obj.book(30,40));
        System.out.println(obj.book(14,29));
        System.out.println(obj.book(3,19));
        System.out.println(obj.book(3,14));
        System.out.println(obj.book(25,39));
        System.out.println(obj.book(6,19));
    }


    Map<Integer, List<Integer>> map = new HashMap<>();


    public MyCalendarII() {

    }

    public boolean book(int start, int end) {
        int count = 0;
        int count1 = 0;
        boolean result = true;


        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            if (end > entry.getKey() && start <= entry.getKey()) {
                List freq = entry.getValue();
                count = freq.size() + 1 + count;
            }

            List<Integer> freqList = entry.getValue();

            for (int freq : freqList) {
                if (start >= entry.getKey() && end <= freq) {
                    count1 = 1 + count1;
                }
            }

            if (count > 2 || count1 > 1) {
                result = false;
                break;
            }
        }

        if (null == map.get(start)) {
            List<Integer> list = new ArrayList();
            list.add(end);
            map.put(start, list);

        } else {
            List<Integer> temp = map.get(start);
            temp.add(end);
            map.put(start, temp);
        }


        return result;
    }
}
