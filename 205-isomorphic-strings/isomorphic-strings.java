class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if(map.containsKey(original)) {
                if(map.get(original) != replacement) {
                    return false;
                }
            } else {
                // Note: For full isomorphism, you also need to check if 'replacement' is already mapped to another character.
                if(map.containsValue(replacement)) {
                     return false;
                }
                map.put(original, replacement);
            }
        }
        return true;
    }
}