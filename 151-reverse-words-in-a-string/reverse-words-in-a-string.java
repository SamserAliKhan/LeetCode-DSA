import java.lang.String;
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = " "+s;
        String ns = "";
        int l = s.length();
        int c=l;
        for(int i=l-1 ; i>=0 ; i--){
            if(s.charAt(i)==' '){
                ns+=s.substring(i,c);
                
                c=i;
            }
            ns = ns.trim();
            
        }
        ns = ns.trim();
        return ns;
    }
}