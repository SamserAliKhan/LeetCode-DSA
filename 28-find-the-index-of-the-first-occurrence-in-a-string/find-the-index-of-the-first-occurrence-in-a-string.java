class Solution {
    public int strStr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(m>n) return -1;
        for(int i = 0 ; i<=n-m ; i++){
            if(s1.substring(i,i+m).equals(s2)){
                return i;
            }
        }
        return -1;
    }
}