package com.leetcode.array;

public class ProductOfLastKNum {

    public static void main(String[] args) {
        new ProductOfLastKNum().add(3);
        new ProductOfLastKNum().add(0);
        new ProductOfLastKNum().add(2);
        new ProductOfLastKNum().add(5);
        new ProductOfLastKNum().add(4);
        int a = new ProductOfLastKNum().getProduct(2);
        int b = new ProductOfLastKNum().getProduct(3);
        int c = new ProductOfLastKNum().getProduct(4);
        System.out.println("ddffdfd");
    }

    static int arr[] = new int[40000];
    static int currIndex = -1;
    static int product = 1;

    public ProductOfLastKNum() {

    }

    public void add(int num) {
        product = num == 0 ? 1 : product * num;
        arr[++currIndex] = num == 0 ? 0 : product;
    }

    public int getProduct(int k) {
        int prodCurr = arr[currIndex];
        int prodPre = arr[currIndex - k];
        if (prodPre == 0 && arr[currIndex + 1 - k] > 0) {
            prodPre = 1;
        } else if (arr[currIndex + 1 - k] == 0) {
            return 0;
        }
        return prodPre == 0 ? 0 : prodCurr / prodPre;
    }
}
