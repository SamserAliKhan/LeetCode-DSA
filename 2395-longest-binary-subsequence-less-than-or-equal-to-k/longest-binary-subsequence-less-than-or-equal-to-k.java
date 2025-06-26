class Solution {
    public int longestSubsequence(String s, int k) {
        int l = s.length() - 1;
        int c = 0, len = 0;
        long sum = 0;

        for (int i = l; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '0') {
                len++;
            } else {
                if (c >= 63 || (1L << c) > (k - sum)) {
                    // Can't include this 1 safely
                } else {
                    sum += (1L << c);
                    len++;
                }
            }
            c++;
        }

        return len;
    }
}
