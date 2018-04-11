public class Stocks {
    public static void main(String[] args) {

        int[] stockPricesYesterday = new int[] {10, 8, 5, 1};
        int answer = getMaxProfit(stockPricesYesterday);
        System.out.println("The answer is " + answer);
    }

    // Strategy: The max profit will be the two prices that produce the greatest difference
    // Iterate through the array keep track of the maxDifference and the lowest value
    static int getMaxProfit(int[] stockPrices) {
        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        int lowestPrice = stockPrices[0];
        int maxDifference = stockPrices[1] - stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {
            if (stockPrices[i] - lowestPrice > maxDifference) {
                maxDifference = stockPrices[i] - lowestPrice;
            }

            if (stockPrices[i] < lowestPrice) {
                lowestPrice = stockPrices[i];
            }
        }
        return maxDifference;
    }
}
