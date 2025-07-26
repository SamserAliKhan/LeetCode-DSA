class Solution {
    /**
     * Calculates the number of subarrays with a sum of exactly the goal.
     * The logic is: count(exactly goal) = count(at most goal) - count(at most goal - 1)
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    /**
     * Helper function to count the number of subarrays with a sum of AT MOST k.
     */
    private int atMost(int[] nums, int k) {
        // If k is negative, no subarray can have a sum less than or equal to it.
        if (k < 0) {
            return 0;
        }

        int left = 0;
        int currentSum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand the window by adding the rightmost element.
            currentSum += nums[right];

            // While the window's sum is too large, shrink it from the left.
            while (currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            // At this point, the window sum is at most k.
            // The number of new subarrays ending at 'right' that satisfy this condition
            // is the size of the current window (right - left + 1).
            count += (right - left + 1);
        }

        return count;
    }
}