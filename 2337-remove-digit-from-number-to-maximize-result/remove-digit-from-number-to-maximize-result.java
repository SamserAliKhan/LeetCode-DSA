class Solution {
    public String removeDigit(String number, char digit) {
       String maxResult = "";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String candidate = number.substring(0, i) + number.substring(i + 1);
                if (candidate.compareTo(maxResult) > 0) {
                    maxResult = candidate;
                }
            }
        }
        return maxResult;
    }
}