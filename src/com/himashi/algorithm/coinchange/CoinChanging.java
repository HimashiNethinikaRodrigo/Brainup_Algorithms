package com.himashi.algorithm.coinchange;

/**
 * Suppose we have coin denominations of [1, 2, 5] and the total amount is 7.
 * How many ways can we make changes for the amount using given coins?
 * You're provided with infinite number of coins
 *
 * Runtime Complexity: O(n*m)
 * Memory Complexity: O(n)
 */
public class CoinChanging {
    public static void main(String[] args) {
        int[] denominations ={1, 2, 5};
        int amount = 7;

        System.out.println(coinChangingResult(denominations, amount));

    }

    private static int coinChangingResult(int[] denominations, int amount) {
        int[] resultArray = new int[amount+1];
        resultArray[0] = 1;
        for (int coin: denominations) {
            for (int i = coin; i <= amount ; i++) {
                resultArray[i] += resultArray[i-coin];
            }
        }
        return resultArray[resultArray.length-1];
    }
}
