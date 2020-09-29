package com.leetcode.array;

public class MaxOfAbsValExpression {

    public static void main(String[] args) {
        int[] arr1 = {1,-2,-5,0,10};
        int[] arr2 = {0,-2,-1,-7,-4};
        int output = new MaxOfAbsValExpression().maxAbsValExpr(arr1, arr2);
        System.out.println(output);
    }

    // abs(A) + abs(B) = max(A+B, A-B, -A+B, -A-B).
    // |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        int[] s1 = new int[arr1.length];
        int[] d1 = new int[arr1.length];
        int[] s2 = new int[arr1.length];
        int[] d2 = new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            s1[i] = arr1[i]+arr2[i]+i;
            d1[i] = arr1[i]-arr2[i]+i;
            s2[i] = arr1[i]+arr2[i]-i;
            d2[i] = arr1[i]-arr2[i]-i;
        }
       // return Math.max(Math.max(find(s1),find(d1)),Math.max(find(s2),find(d2)));
        return Math.max(Math.max(find(s1),find(d1)),Math.max(find(s2),find(d2)));
    }
    private int find(int[] s){
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for(int i=0;i<s.length;i++){
            if(mx<s[i])
                mx=s[i];
            if(mn>s[i])
                mn=s[i];
        }
        return (mx-mn);

    }
}
