class Solution {
    public int totalFruit(int[] arr) {
        Map<Integer, Integer> map = new HashMap <>();
        int l=0 , r=0;
        int n=arr.length;
        int maxLen=0;
        while(r<n){
            //expand:
            if(map.containsKey(arr[r]))map.put(arr[r],map.get(arr[r])+1);
            else map.put(arr[r],1);

            //Shrink:
            if(map.size() > 2){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0)map.remove(arr[l]);
                l++;
            }
            
            maxLen = Math.max(maxLen,(r - l + 1));
            r++;
        }
        return maxLen;
    }
}