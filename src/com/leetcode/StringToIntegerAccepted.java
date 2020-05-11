package com.leetcode;

public class StringToIntegerAccepted {
    public static void main(String[] args) {
        int num = new StringToIntegerAccepted().myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"); // -2147483648
        System.out.println(num);
    }
    public int myAtoi(String str) {
        StringBuilder sb  = new StringBuilder();

        int asciiZero = (int)'0';
        int asciiNine = (int)'9';

        boolean firstDigitFound = false;
        boolean isNegative = false;
        boolean isPositive = false;
        boolean ignore = false;
        int count = 0;

        for (int i = 0 ; i < str.length() ; i++) {

            int indexValue = (int)str.charAt(i);

            boolean isDigit = indexValue >= asciiZero && indexValue <= asciiNine;

            if (!isNegative) {
                isNegative =  str.charAt(i) == '-'
                        && i < str.length() - 1
                        && (int)str.charAt(i+1) >= asciiZero && (int)str.charAt(i+1) <= asciiNine;
            }

            if (!isPositive) {
                isPositive =  str.charAt(i) == '+'
                        && i < str.length() - 1
                        && (int)str.charAt(i+1) >= asciiZero && (int)str.charAt(i+1) <= asciiNine;
            }

            if (str.charAt(i) == ' ' && !firstDigitFound) {
                continue;
            }

            if (firstDigitFound && !isDigit) {
                ignore = true;
            }

            if (!firstDigitFound && !isDigit && !isNegative && !isPositive) {
                return 0;
            }

            if (isDigit && !ignore) {
                count++;
                firstDigitFound = true;
                sb.append(str.charAt(i));
            }
        }
        int negOrPos = isNegative ?  -1 : 1;

        return convertToNumber(sb.toString(), negOrPos, count);

    }

    private int convertToNumber(String str, int negOrPos, int count) {
        int asciiZero = (int) '0';
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            long digit = (int) ch - asciiZero;
            sum = sum + digit * findPow(--count);
            if (negOrPos > 0 && (sum > Integer.MAX_VALUE || sum <0   )) {
                return Integer.MAX_VALUE;
            }
            if (negOrPos < 0 && sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        sum = negOrPos * sum;
        if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sum < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)sum;
    }

    private long findPow(int j) {
        long multiply = 1;
        for (int i = 0; i < j; i++) {
            multiply = multiply * 10;
            if (multiply > Integer.MAX_VALUE) {
                multiply = Integer.MAX_VALUE;
                break;
            }
        }
        return multiply;
    }

}
