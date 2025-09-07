class Solution {
    public char findTheDifference(String s, String t) {
        if(s.equals("")){
            char res = t.charAt(0);
            return res;
        }
        char ch = (char) 0;
        for(int i = 0 ; i<s.length(); i++){
            ch = (char)(ch ^ s.charAt(i));
        }
        for(int i = 0 ; i<t.length(); i++){
            ch = (char)(ch ^ t.charAt(i));
        }
        return ch;
    }
}