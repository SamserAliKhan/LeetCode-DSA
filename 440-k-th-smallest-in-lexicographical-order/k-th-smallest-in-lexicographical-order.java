class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1; // Current number we are considering, starting from the smallest (1)
        k--; // Decrement k because curr=1 is the first number. We are looking for the k-th *after* curr.

        while (k > 0) {
            // Calculate the count of numbers in the current subtree
            // (e.g., if curr is 1, this counts 1, 10-19, 100-199, etc., up to n)
            long count = getCount(curr, n);

            if (k >= count) {
                // The k-th number is not in the current subtree.
                // We need to move to the next sibling (e.g., from 1 to 2, or 10 to 11).
                curr++;
                k -= count; // Subtract the count of numbers we just skipped
            } else {
                // The k-th number is in the current subtree.
                // We need to go deeper into this subtree (e.g., from 1 to 10).
                curr *= 10;
                k--; // Decrement k because we've moved one step deeper (counted curr itself)
            }
        }

        return (int) curr;
    }

    /**
     * Calculates the number of integers in the range [1, n] that have 'curr' as a prefix.
     * For example, if curr=1 and n=13:
     * Counts: 1 (itself)
     * 10, 11, 12, 13 (from 10 to 19, but limited by n=13)
     * Total = 1 + 4 = 5
     */
    private long getCount(long curr, int n) {
        long count = 0;
        long next = curr + 1; // Represents the start of the next sibling's range (e.g., if curr=1, next=2)

        while (curr <= n) {
            // Add the number of elements in the current level's segment within the range [curr, next-1]
            // and limited by n.
            // For example, if curr=10, next=11: we count 10 itself.
            // If curr=100, next=101: we count 100 itself.
            // If curr=10, next=20, n=13: min(13+1, 20) - 10 = 14 - 10 = 4 (counts 10, 11, 12, 13)
            count += Math.min((long) n + 1, next) - curr;
            
            curr *= 10; // Move to the next level (e.g., from 1 to 10)
            next *= 10; // Adjust the next boundary accordingly (e.g., from 2 to 20)
        }
        return count;
    }
}