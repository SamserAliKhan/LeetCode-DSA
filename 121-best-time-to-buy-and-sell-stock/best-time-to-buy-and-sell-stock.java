class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)return 0;
        int max = 0;
        int min = prices[0];
        for(int i : prices){
            min = Math.min(i,min);
            max = Math.max(max,i-min);
        }
        return max;
    }
}