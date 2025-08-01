class Solution {
    public int maxProfit(int[] prices) {
        int minBuy=prices[0];
        int maxProfit=0;
        int i=0; //itarative
        int n = prices.length; 
        while(i!=n){
            if(prices[i]<minBuy)minBuy = Math.min(minBuy,prices[i]);
            else maxProfit=Math.max(maxProfit,prices[i]-minBuy);
            i++;
        }
        return maxProfit;
    }
}