import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxDistance(String s, int k) {
        int maxManhattan = 0;

        // Case 1: Maximize x + y
        // 'N': (0,1) -> x+y increases by 1
        // 'S': (0,-1) -> x+y decreases by 1 (bad move)
        // 'E': (1,0) -> x+y increases by 1
        // 'W': (-1,0) -> x+y decreases by 1 (bad move)
        Map<Character, Integer> scores1 = new HashMap<>();
        scores1.put('N', 1);
        scores1.put('S', -1);
        scores1.put('E', 1);
        scores1.put('W', -1);
        maxManhattan = Math.max(maxManhattan, calculateMaxScore(s, k, scores1));

        // Case 2: Maximize x - y
        // 'N': (0,1) -> x-y decreases by 1 (bad move)
        // 'S': (0,-1) -> x-y increases by 1
        // 'E': (1,0) -> x-y increases by 1
        // 'W': (-1,0) -> x-y decreases by 1 (bad move)
        Map<Character, Integer> scores2 = new HashMap<>();
        scores2.put('N', -1);
        scores2.put('S', 1);
        scores2.put('E', 1);
        scores2.put('W', -1);
        maxManhattan = Math.max(maxManhattan, calculateMaxScore(s, k, scores2));

        // Case 3: Maximize -x + y
        // 'N': (0,1) -> -x+y increases by 1
        // 'S': (0,-1) -> -x+y decreases by 1 (bad move)
        // 'E': (1,0) -> -x+y decreases by 1 (bad move)
        // 'W': (-1,0) -> -x+y increases by 1
        Map<Character, Integer> scores3 = new HashMap<>();
        scores3.put('N', 1);
        scores3.put('S', -1);
        scores3.put('E', -1);
        scores3.put('W', 1);
        maxManhattan = Math.max(maxManhattan, calculateMaxScore(s, k, scores3));

        // Case 4: Maximize -x - y
        // 'N': (0,1) -> -x-y decreases by 1 (bad move)
        // 'S': (0,-1) -> -x-y increases by 1
        // 'E': (1,0) -> -x-y decreases by 1 (bad move)
        // 'W': (-1,0) -> -x-y increases by 1
        Map<Character, Integer> scores4 = new HashMap<>();
        scores4.put('N', -1);
        scores4.put('S', 1);
        scores4.put('E', -1);
        scores4.put('W', 1);
        maxManhattan = Math.max(maxManhattan, calculateMaxScore(s, k, scores4));

        return maxManhattan;
    }

    private int calculateMaxScore(String s, int k, Map<Character, Integer> scores) {
        int currentRawScore = 0; // The sum of scores if no changes were made
        int negCount = 0;        // Count of moves that originally had a score of -1
        int maxScore = 0;        // The maximum score achieved over all prefixes, considering k changes

        for (char c : s.toCharArray()) {
            int scoreC = scores.get(c);
            currentRawScore += scoreC;

            if (scoreC == -1) {
                negCount++;
            }

            // Calculate the effective score for the current prefix
            // We can change 'min(negCount, k)' of the -1 score moves to +1 score moves.
            // Each such change adds 2 to the sum (from -1 to +1).
            int effectiveBonus = 2 * Math.min(negCount, k);
            maxScore = Math.max(maxScore, currentRawScore + effectiveBonus);
        }
        return maxScore;
    }
}