class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int max = 0;
        int r=0 , l=0;
        Map<Character,Integer> map = new HashMap<>();
        char ch;
        while(r<s.length()){
            ch = s.charAt(r);
            if(map.containsKey(ch)){
                //duplicate value found
                l = Math.max(l,map.get(ch)+1);
            }
            map.put(ch,r);
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}