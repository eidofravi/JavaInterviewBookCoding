package com.leetcode;

public class FruitInABasket {
    public static void main(String[] args) {
        System.out.println(new FruitInABasket().totalFruit(new int[]{1, 2, 1}) == 3); //3
        System.out.println(new FruitInABasket().totalFruit(new int[]{0, 0, 1, 1}) == 4); //3
        System.out.println(new FruitInABasket().totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6}) == 5); //3
        System.out.println(new FruitInABasket().totalFruit(new int[]{0, 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}) == 5); //5
        System.out.println(new FruitInABasket().totalFruit(new int[]{0, 1, 2, 2}) == 3); //3
        System.out.println(new FruitInABasket().totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}) == 5); //3
        System.out.println(new FruitInABasket().totalFruit(new int[]{0, 0, 5, 0, 0, 1, 0, 4, 0, 4}) == 5); //3
    }

    public int totalFruit(int[] tree) {
        Integer basket1 = null;
        Integer basket2 = null;
        Integer indexBasket1 = 0;
        Integer indexBasket2 = 0;
        int totalCount = 0;
        int basket1count = 0;
        int basket2count = 0;

        for (int i = 0; i < tree.length; i++) {

            if (null == basket1 || tree[i] == basket1) {
                basket1 = tree[i];
                indexBasket1 = i;
                basket1count++;
            } else if (null == basket2 || tree[i] == basket2) {
                basket2 = tree[i];
                indexBasket2 = i;
                basket2count++;
            } else {
                totalCount = Math.max(totalCount, (basket1count + basket2count));
                if (basket1 == tree[i - 1]) {
                    basket1count = indexBasket1 - indexBasket2;
                    basket2count = 0;
                    basket2 = tree[i];
                    basket2count ++;
                    indexBasket2 = i;
                } else {
                    basket2count = indexBasket2 - indexBasket1;
                    basket1count = 0;
                    basket1 = tree[i];
                    basket1count ++;
                    indexBasket1 = i;
                }
            }
        }
        return Math.max(totalCount, (basket1count + basket2count));
    }
}
