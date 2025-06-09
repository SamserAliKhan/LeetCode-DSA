class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0,cMax=0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]==1){
                c++;
                if(cMax<=c)cMax=c;
            }else c=0;
        }
        return cMax;
    }
}