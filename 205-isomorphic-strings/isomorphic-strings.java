class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        // Arrays to store the mappings. 
        // We use size 256 to cover standard ASCII characters.
        char[] mapS = new char[256];
        char[] mapT = new char[256];

        for(int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Case 1: If we have seen charS before, it MUST map to the same charT
            if(mapS[charS] != 0 && mapS[charS] != charT) {
                return false;
            }

            // Case 2: If we have seen charT before, it MUST map to the same charS
            if(mapT[charT] != 0 && mapT[charT] != charS) {
                return false;
            }

            // If neither has been seen, create the mapping
            mapS[charS] = charT;
            mapT[charT] = charS;
        }

        return true;
    }
}
