class Solution {
    public String addBinary(String a, String b) {
        // Use StringBuilder for efficient string building
        StringBuilder result = new StringBuilder();
        
        // Pointers for the end of each string
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carry = 0;
        
        // Loop as long as there are digits in either string OR a carry is left
        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bit2 = (j >= 0) ? b.charAt(j) - '0' : 0;
            
            // Calculate the sum of bits and the carry
            int sum = bit1 + bit2 + carry;
            
            // The current digit for the result is sum % 2
            result.append(sum % 2);
            
            // The new carry is sum / 2
            carry = sum / 2;
            
            // Move pointers to the left
            i--;
            j--;
        }
        
        // The result is built in reverse, so reverse it back before returning
        return result.reverse().toString();
    }
}