class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int MaxOdd=Integer.MIN_VALUE;
        int MinEven=Integer.MAX_VALUE;
        for(char ch : map.keySet()){
            int c=map.get(ch);
            if(c%2!=0){
                MaxOdd=Math.max(MaxOdd,c);
            }
            else{
                MinEven=Math.min(MinEven,c);
            }
        }
        return (MaxOdd-MinEven);
    }
}