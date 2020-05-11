package com.leetcode;

public class StringToInteger {
    public static void main(String[] args) {
        int num = new StringToInteger().myAtoi("-91283472332"); // -2147483648
        System.out.println(num);
    }

    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();

        int asciiZero = (int) '0';
        int asciiNine = (int) '9';

        boolean firstDigitFound = false;
        boolean isNegative = false;
        boolean isPositive = false;
        boolean ignore = false;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            int indexValue = str.charAt(i);

            boolean isDigit = indexValue >= asciiZero && indexValue <= asciiNine;

            if (firstDigitFound && !isDigit) {
                break;
            }
            if (str.charAt(i) == ' ') {
                continue;
            }

            if (!isNegative) {
                isNegative = str.charAt(i) == '-'
                        && i < str.length() - 1
                        && (int) str.charAt(i + 1) >= asciiZero && (int) str.charAt(i + 1) <= asciiNine;
            }

            if (!isPositive) {
                isPositive = str.charAt(i) == '+'
                        && i < str.length() - 1
                        && (int) str.charAt(i + 1) >= asciiZero && (int) str.charAt(i + 1) <= asciiNine;
            }

            if (!isDigit && !isNegative && !isPositive) {
                return 0;
            }

            if (isDigit) {
                count++;
                firstDigitFound = true;
                sb.append(str.charAt(i));
            }
        }
        int negOrPos = isNegative ? -1 : 1;

        return convertToNumber(sb.toString(), negOrPos, count);
    }

    private int convertToNumber(String str, int negOrPos, int count) {
        int asciiZero = '0';
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            long digit = (int) ch - asciiZero;
            sum = sum + findPow(--count, negOrPos * digit);
            if (sum > Integer.MAX_VALUE) {
                sum = Integer.MAX_VALUE;
                break;
            }
            if (sum < Integer.MIN_VALUE) {
                sum = Integer.MIN_VALUE;
                break;
            }
        }
        return  (int)sum;
    }

    private long findPow(int j, long multiply) {
        for (int i = 0; i < j; i++) {
            multiply = multiply * 10;
            if (multiply > Integer.MAX_VALUE) {
                multiply = Integer.MAX_VALUE;
                break;
            }
            if (multiply < Integer.MIN_VALUE) {
                multiply = Integer.MIN_VALUE;
                break;
            }
        }
        return multiply;
    }

}
