package com.leetcode.array;

public class MaxSumTwoNoOverlap2 {

    public static void main(String[] args) {
       // int[] A = {3, 8, 1, 3, 2, 1, 8, 9, 0};
      //  int L = 3;
     //   int M = 2;
        int[] A = {2,1,5,6,0,9,5,0,3,8};
        int L = 4;
        int M = 3;
        int output = new MaxSumTwoNoOverlap2().maxSumTwoNoOverlap(A, L, M);
        System.out.println(output);
    }


    public int maxSumTwoNoOverlap(int[] A, int L, int M) {

        int Larr[] = new int[A.length];
        int Marr[] = new int[A.length];

        int prevLarr = 0;
        int prevMarr = 0;

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                for (int j = 0; j < L; j++) {
                    prevLarr = prevLarr + A[j];
                    Larr[i] = prevLarr;
                }
            } else if (i > 0 && i <= A.length - L) {
                Larr[i] = prevLarr - A[i - 1] + A[i + L - 1];
                prevLarr = Larr[i];
            }

            if (i == 0) {
                for (int j = 0; j < M; j++) {
                    prevMarr = prevMarr + A[j];
                    Marr[i] = prevMarr;
                }
            } else if (i > 0 && i <= A.length - M) {
                Marr[i] = prevMarr - A[i - 1] + A[i + M - 1];
                prevMarr = Marr[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < Larr.length; i++) {
            for (int j = 0; j < Marr.length; j++) {
                if (j >= i + L || j < i - M) {
                    sum = Math.max(sum, Larr[i] + Marr[j]);
                }
            }
        }
        return sum;
    }
}
