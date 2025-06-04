class Solution {
    public void moveZeroes(int[] nums) {
        int c=0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]!=0){
                //swap nums[c] with nums[i];
                int temp = nums[c];
                nums[c] = nums[i];
                nums[i] = temp;
                c++;
            }
        }
        return;
    }
}