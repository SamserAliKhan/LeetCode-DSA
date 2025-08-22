class Solution {
    public int missingNumber(int[] nums) {
        int res=0 ,i=0,sum=0 ;
        while(i<nums.length){
            res ^=nums[i];
            sum ^= i;
            i++;
        }
        sum ^= nums.length;
        return res^sum;
    }
}