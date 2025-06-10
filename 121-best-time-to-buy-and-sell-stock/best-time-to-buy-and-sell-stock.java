class Solution {
    public int maxProfit(int[] prices) {
        int minPrice =Integer.MAX_VALUE;
        int l=prices.length,maxPrice=0;
        for(int i=0; i<l ; i++){
            if(prices[i]<minPrice) minPrice=prices[i];
            else {
                maxPrice=Math.max(maxPrice,prices[i]-minPrice);
            }
        }
        return maxPrice;
    }
}