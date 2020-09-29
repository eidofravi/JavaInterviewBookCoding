package com.leetcode.array;

public class MaxSumTwoNoOverlap {

    public static void main(String[] args) {
       // int[] A = {3, 8, 1, 3, 2, 1, 8, 9, 0};
      //  int L = 3;
     //   int M = 2;
        int[] A = {2,1,5,6,0,9,5,0,3,8};
        int L = 4;
        int M = 3;
        int output = new MaxSumTwoNoOverlap().maxSumTwoNoOverlap(A, L, M);
        System.out.println(output);
    }


    public int maxSumTwoNoOverlap(int[] a, int l, int m) {
        int n = a.length;
        int[] prefix = new int[n];
        prefix[0]=a[0];
        for(int i =1;i<n;i++)
            prefix[i]=a[i]+prefix[i-1];

        return Math.max(maxSum(prefix,l,m),maxSum(prefix,m,l));
    }

    private int maxSum(int[] prefix,int l,int m) {
        int max_sum=subArraySum(prefix,0,l-1)+subArraySum(prefix,l,l+m-1);
        int max_first=subArraySum(prefix,0,l-1);
        //[0..l-1][l,l+m-1]
        for(int i=l+m-1;i<prefix.length;i++) {
            int first = subArraySum(prefix,i-l-m+1,i-m);
            max_first = Math.max(max_first,first);

            int sum= max_first + subArraySum(prefix,i-m+1,i);
            max_sum = Math.max(max_sum,sum);
        }

        return max_sum;
    }

    //a[3]+a[4]+a[5]=prefix[5]-prefix[2]
    private int subArraySum(int[] prefix,int from, int to) {
        if (from ==0) return prefix[to];
        else return prefix[to]-prefix[from-1];
    }

}
