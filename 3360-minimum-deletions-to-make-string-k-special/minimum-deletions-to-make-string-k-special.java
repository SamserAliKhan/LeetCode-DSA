import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        // Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Extract frequencies into a list
        List<Integer> freqs = new ArrayList<>(freqMap.values());
        Collections.sort(freqs); // Optional: helps iterate efficiently

        int minDeletions = Integer.MAX_VALUE;

        for (int x : freqs) {
            int deletions = 0;
            for (int y : freqs) {
                if (y < x) {
                    deletions += y; // delete all
                } else if (y > x + k) {
                    deletions += y - (x + k); // delete excess
                }
                // else: within range, no deletion
            }
            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}
