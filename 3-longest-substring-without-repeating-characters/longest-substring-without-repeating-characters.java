import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
       if(s==null||s.length()==0)
        return 0;
        else{
            int r=0,l=0,n=s.length()-1;
            int max=0;
            HashMap<Character,Integer> map = new HashMap<>();
            while(r<=n){
                char ch=s.charAt(r);
                if(map.containsKey(ch)){
                    //duplicate value found
                    l=Math.max(l,map.get(ch)+1);
                }

                map.put(ch,r);
                max = Math.max(max,r-l+1);
                r++;
            }
            return max;
        }
       
    }
}