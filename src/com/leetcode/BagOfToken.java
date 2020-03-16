package com.leetcode;

import java.util.Arrays;

public class BagOfToken {
    public static void main(String[] args) {
      new BagOfToken().bagOfTokensScore(new int[]{100, 200, 700, 800, 900, 1000}, 150);
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int sumToken = getSumOfToken(tokens);
        int availPoints = tokens.length;
        if (power >= sumToken) {
            return availPoints;
        }
        int stIndex = 0;
        int endIndex = tokens.length - 1;
        int gainedPoint = 0;
        if (tokens[stIndex] > power) {
            return 0;
        }
        //givePowerForPoint
        power = power - tokens[stIndex++];
        gainedPoint++;
        availPoints--;
        sumToken = sumToken - tokens[stIndex];

        while(availPoints > 0) {
            // givePointsForPower
            power = power + tokens[endIndex];
            sumToken = sumToken - tokens[endIndex];
            if (power < sumToken) {
                power = power - tokens[stIndex++];
                gainedPoint++;
                availPoints--;
                sumToken = sumToken - tokens[stIndex];
            }

        }






        return gainedPoint;
    }

    private void givePointForPower() {

    }

    private void givePowerForPoint(int power, int sumToken) {

    }

    private int getSumOfToken(int[] tokens) {
        int sum = 0 ;
        for (int i = 0 ; i < tokens.length; i++) {
            sum = sum + tokens[i];
        }
        return sum;
    }

}
