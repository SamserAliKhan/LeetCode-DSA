class Solution {
    public int missingNumber(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int n = nums.length;
       for(int i=0 ; i<n ; i++) {
        map.put(nums[i],1);
       }
       boolean check = map.containsKey(n);
       if(check){
            for(int i=0 ; i<n ; i++){
                if(map.containsKey(i)){continue;}
                else {return i;}
            }
       }
       else return n;
       
       return -1;
    }
}