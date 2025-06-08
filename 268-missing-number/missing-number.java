class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actualSum = n;
        int Sum = 0;
       for(int i=0 ; i<n ; i++) {
            actualSum += i;
            Sum += nums[i];
       }
       return actualSum - Sum;
    }
}