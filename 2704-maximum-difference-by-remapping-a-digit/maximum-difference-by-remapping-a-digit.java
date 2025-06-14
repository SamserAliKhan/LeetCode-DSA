class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (char d1 = '0'; d1 <= '9'; d1++) {
            for (char d2 = '0'; d2 <= '9'; d2++) {
                if (d1 == d2) continue;
                String replaced = s.replace(d1, d2);
                int val = Integer.parseInt(replaced);
                max = Math.max(max, val);
                min = Math.min(min, val);
            }
        }

        return max - min;
    }
}
