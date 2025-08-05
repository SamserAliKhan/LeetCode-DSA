class Solution {
    // These will be class members to be accessible by the helper methods.
    private int[] tree;     // The segment tree array
    private int[] baskets;  // A reference to the input baskets array
    private int n;          // The size of the baskets array

    /**
     * Main method to calculate the number of unplaced fruits.
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        this.n = baskets.length;
        if (n == 0) {
            return fruits.length; // No baskets, no fruits can be placed.
        }
        
        this.baskets = baskets;
        // A segment tree typically requires up to 4*n space.
        this.tree = new int[4 * n];
        
        // Step 1: Build the segment tree from the baskets array.
        build(1, 0, n - 1);
        
        int unplacedCount = 0;
        for (int fruitQuantity : fruits) {
            // Step 2: For each fruit, query the tree for the leftmost valid basket.
            // This search operation takes O(log n) time.
            int basketIndex = query(1, 0, n - 1, fruitQuantity);
            
            if (basketIndex != -1) {
                // Step 3: If a basket is found, update the tree to mark it as "used".
                // This update operation also takes O(log n) time.
                update(1, 0, n - 1, basketIndex);
            } else {
                // If no suitable basket is found after the search.
                unplacedCount++;
            }
        }
        return unplacedCount;
    }

    /**
     * Builds the segment tree. Each node stores the maximum capacity in its range.
     * @param node The current node index in the 'tree' array.
     * @param start The starting index of the range in the original 'baskets' array.
     * @param end The ending index of the range.
     */
    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = baskets[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    /**
     * Updates the segment tree after a basket at a given index is used.
     * We set its capacity to -1 to signify it's no longer available.
     */
    private void update(int node, int start, int end, int index) {
        if (start == end) {
            tree[node] = -1; // Mark as unavailable
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            update(2 * node, start, mid, index);
        } else {
            update(2 * node + 1, mid + 1, end, index);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    /**
     * Queries the segment tree for the leftmost index with a capacity >= 'value'.
     * Returns -1 if no such index is found.
     */
    private int query(int node, int start, int end, int value) {
        // If the max capacity in this entire range is less than what we need,
        // then no answer can be found in this branch.
        if (tree[node] < value) {
            return -1;
        }
        // If we are at a leaf node, we have found a potential basket.
        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;
        int result = -1;
        
        // We must prioritize the left child to find the "leftmost" index.
        // Only if the left child's max capacity is sufficient do we search within it.
        if (tree[2 * node] >= value) {
            result = query(2 * node, start, mid, value);
        }

        // If the left child didn't yield a result, search the right child.
        if (result == -1) {
            result = query(2 * node + 1, mid + 1, end, value);
        }

        return result;
    }
}