class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = nums.length;
        map.put(0,0);
        map.put(1,0);
        map.put(2,0);
        for(int i=0 ; i<n ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],(map.get(nums[i])+1));
            }
        }
        int c = 0;
        if(map.containsKey(0)){
            for(int i=c ; i<map.get(0) ; i++,c++){
               nums[c]=0;
            }
        }
        if(map.containsKey(1)){
            for(int i=0 ; i< map.get(1) ; i++,c++){
                nums[c]=1;
            }
        }
        if(map.containsKey(2)){
            for(int i=0 ; i<map.get(2) ; i++,c++){
                nums[c]=2;
            }
        }
        return ;
    }
}