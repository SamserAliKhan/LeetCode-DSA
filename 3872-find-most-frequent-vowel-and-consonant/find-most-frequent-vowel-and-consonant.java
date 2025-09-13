class Solution {
    public int maxFreqSum(String s) {
        int[] arr = new int [26];

        for(int i=0 ; i<s.length() ; i++){
            int dif = s.charAt(i)-'a';
            arr[dif] += 1;
        }

        int vMax = 0;
        int cMax = 0;
        
        for(int i=0 ; i<arr.length ; i++){
            char ch = (char) ('a'+i);
            if(ch == 'a'|| ch =='e'|| ch =='i'|| ch =='o'|| ch =='u'){
                vMax = Math.max(vMax,arr[i]);
            }
            else {
                cMax = Math.max(cMax,arr[i]);
            }
        }

        return cMax + vMax;
    }
}