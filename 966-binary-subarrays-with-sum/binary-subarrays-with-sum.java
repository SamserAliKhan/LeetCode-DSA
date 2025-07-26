class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0;
        int c=0;
        for(int i=0 ; i<n ; i++){
            sum=0;
            for(int j=i ; j<n ; j++){
                sum += nums[j];
                if(sum==goal)c++;
                if(sum>goal)break;
            }
        }
        return c;
    }
}