class Solution {
    public String convertToTitle(int columnNumber) {
        // StringBuilder is efficient for building strings in a loop
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // This is the crucial step. We map the 1-based number (1-26)
            // to a 0-based index (0-25) before taking the modulo.
            // This correctly handles cases like Z (26) and AZ (52).
            columnNumber--; 
            
            // Get the remainder to find the character for the current position.
            // 0 maps to 'A', 1 to 'B', ..., 25 to 'Z'.
            int remainder = columnNumber % 26;
            char ch = (char) ('A' + remainder);
            
            // Append the character. We'll reverse the whole string at the end.
            result.append(ch);
            
            // Move to the next digit to the left.
            columnNumber = columnNumber / 26;
        }
        
        // The result was built from right-to-left, so we must reverse it.
        return result.reverse().toString();
    }
}