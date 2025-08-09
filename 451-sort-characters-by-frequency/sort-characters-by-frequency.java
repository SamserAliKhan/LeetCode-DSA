class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[256]; // fixed size for ASCII
        int maxFreq = 0;
        
        // Step 1: Count frequencies
        for (char c : s.toCharArray()) {
            freq[c]++;
            maxFreq = Math.max(maxFreq, freq[c]);
        }
        
        // Step 2: Create buckets
        List<Integer>[] buckets = new List[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Step 3: Fill buckets
        for (int c = 0; c < 256; c++) {
            if (freq[c] > 0) {
                buckets[freq[c]].add(c);
            }
        }
        
        // Step 4: Build output
        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i >= 1; i--) {
            for (int code : buckets[i]) {
                for (int k = 0; k < i; k++) {
                    sb.append((char) code);
                }
            }
        }
        
        return sb.toString();
    }
}
