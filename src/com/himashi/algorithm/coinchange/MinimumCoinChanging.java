package com.himashi.algorithm.coinchange;

public class MinimumCoinChanging {
    public static void main(String[] args) {
        int[] denominations ={1, 5, 6, 9};
        int amount = 10;

        System.out.println(minimumCoinChangingResult(denominations, amount));
    }

    private static int minimumCoinChangingResult(int[] denominations, int amount) {
        int[] resultList = new int[amount+1];
        resultList[0] =0;
        for (int coin : denominations) {
            for (int i = coin; i < amount+1 ; i++) {
                if (resultList[i] == 0) resultList[i] = 1 + resultList[i-coin];
                else resultList[i] = Math.min(resultList[i], 1+ resultList[i-coin]);
            }
        }
        return resultList[resultList.length-1];
    }
}
