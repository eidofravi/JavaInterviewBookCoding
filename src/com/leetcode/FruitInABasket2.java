package com.leetcode;

public class FruitInABasket2 {
    public static void main(String[] args) {
        System.out.println(new FruitInABasket2().totalFruit(new int[] {1,2,1}) == 3); //3
        System.out.println(new FruitInABasket2().totalFruit(new int[] {0,0,1,1}) == 4); //3
        System.out.println(new FruitInABasket2().totalFruit(new int[] {0,1,6,6,4,4,6}) == 5); //3
        System.out.println(new FruitInABasket2().totalFruit(new int[] {0,3,3,3,1,2,1,1,2,3,3,4}) == 5); //5
        System.out.println(new FruitInABasket2().totalFruit(new int[] {0,1,2,2}) == 3); //3
        System.out.println(new FruitInABasket2().totalFruit(new int[] {1,0,1,4,1,4,1,2,3}) == 5); //3
        System.out.println(new FruitInABasket2().totalFruit(new int[] {0,0,5,0,0,1,0,4,0,4}) == 5); //3
    }

    public int totalFruit(int[] tree) {
        Integer basket1 = null;
        Integer basket2= null;
        Integer indexBasket1 = 0;
        Integer indexBasket2= 0;
        int totalCount = 0;
        int count = 0;

        for (int i = 0; i < tree.length; i++) {

            if (null == basket1 || tree[i] == basket1) {
                basket1 = tree[i];
                indexBasket1 = i;
                count++;
            } else if (null == basket2 || tree[i] == basket2) {
                basket2 = tree[i];
                indexBasket2 = i;
                count++;
            } else {
                totalCount = Math.max(totalCount, count);
                i = basket1 == tree[i-1] ? indexBasket2 : indexBasket1;
                if (basket1 == tree[i-1]) {
                    i = indexBasket2;

                } else {
                    i = indexBasket1;
                }
                basket1 = null;
                basket2 = null;
                count = 0;
            }
        }
       return Math.max(totalCount, count);
    }
}
