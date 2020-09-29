package com.leetcode.array.twodimarray;

import java.util.*;

public class MeetingScheduler {

    public static void main(String[] args) {
        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        int duration = 8;

        // int[][] slots1 = {{216397070, 363167701}, {98730764, 158208909}, {441003187, 466254040}, {558239978, 678368334}, {683942980, 717766451}};
        // int[][] slots2 = {{50490609, 222653186}, {512711631, 670791418}, {730229023, 802410205}, {812553104, 891266775}, {230032010, 399152578}};
        // int duration = 456085;

        // int[][] slots1 = {{718384535, 736105571}, {35095260, 90518369}, {538071029, 603359996}, {787143800, 805873909}, {462350441, 473273936}, {234081547, 361269701}, {662315884, 691519923}, {8448628, 21912154}, {132574102, 138895745}, {606910106, 652509906}};
        // int[][] slots2 = {{873692195, 883509573}, {21185676, 36072192}, {118230057, 131648270}, {455946678, 460714279}, {664875016, 747582619}, {216100177, 376327844}, {50846518, 110130562}, {760997807, 780162834}, {578554164, 634157489}, {379022912, 418539635}};
        // int duration = 673228;

        List<Integer> output = new MeetingScheduler().minAvailableDuration(slots1, slots2, duration);
        Collections.sort(output);
        System.out.println(output.get(0));
        System.out.println(output.get(0) + duration);
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);

        List<Integer> output = new ArrayList();
        int fIndex = 0;
        int sIndex = 0;

        while (fIndex < slots1.length && sIndex < slots2.length) {
            int[] arr1 = slots1[fIndex];
            int[] arr2 = slots2[sIndex];

            int arr1start = arr1[0];
            int arr2start = arr2[0];

            if (arr1start >= arr2start) {
                if (arr1start + duration <= arr1[1] && arr1start + duration <= arr2[1]) {
                    output.add(arr1start);
                    output.add(arr1start + duration);
                    return output;
                } else {
                    sIndex++;
                }
            } else if (arr2start > arr1start) {
                if (arr2start + duration <= arr1[1] && arr2start + duration <= arr2[1]) {
                    output.add(arr2start);
                    output.add(arr2start + duration);
                    return output;
                } else {
                    fIndex++;
                }
            }
        }
        return output;
    }
}
