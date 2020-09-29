package com.leetcode.array;

public class StoneGameII {

    public static void main(String[] args) {
        int piles[] = {2,7,9,4,4};
        int output = new StoneGameII().stoneGameII(piles);
        System.out.println(output);
    }

    int [] sum;
    int [][] hash;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        sum = new int[n];
        sum[n-1] = piles[n-1];
        for(int i = n-2; i>=0; i--){
            sum[i] = sum[i+1] + piles[i];
        }

        hash = new int[n][n];

        return dfs(piles, 0, 1);
    }

    private int dfs(int [] piles, int i, int M){
        if(i+2*M >= piles.length){
            return sum[i];
        }

        if(hash[i][M] != 0){
            return hash[i][M];
        }

        int min = Integer.MAX_VALUE;
        for(int x = 1; x<=2*M; x++){
            min = Math.min(min, dfs(piles, i+x, Math.max(M, x)));
        }

        // all the left stones - minimum stones the other player could get
        hash[i][M] = sum[i]-min;
        return hash[i][M];
    }

}
