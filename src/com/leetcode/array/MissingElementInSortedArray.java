package com.leetcode.array;

public class MissingElementInSortedArray {

    public static void main(String[] args) {

        int[] nums = {4,7,9,10};
        int k = 3;

      int output = new MissingElementInSortedArray().missingElement(nums, k);
        System.out.println(output);
    }

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;

        // find missing nums = (number at last index -  number at first index ) - ( last index - first index)
        int missingNum = nums[n - 1] - nums[0] - (n -1 - 0);
        //int missingNum = nums[n - 1] - nums[0] + 1 - n;

        if (missingNum < k) {
            return nums[n - 1] + k - missingNum;
        }

        while (l < h - 1) {
            int m = l + (h - l) / 2;
            int missing = nums[m] - nums[l] - (m - l);

            if (missing >= k) {
                // when the number is larger than k, then the index won't be located in (m, h]
                h = m;
            } else {
                // when the number is smaller than k, then the index won't be located in [l, m), update k -= missing
                k -= missing;
                l = m;
            }
        }

        return nums[l] + k;
    }
}
