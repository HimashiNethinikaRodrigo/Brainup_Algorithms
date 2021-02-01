package com.himashi.algorithm;

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
