class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit =Integer.MAX_VALUE;
        int l=prices.length,res,maxres=0;
        for(int i=0; i<l ; i++){
            if(prices[i]<maxProfit) maxProfit=prices[i];
            else {
                res=prices[i]-maxProfit;
                if(maxres<res)maxres=res;
            }
        }
        return maxres;
    }
}