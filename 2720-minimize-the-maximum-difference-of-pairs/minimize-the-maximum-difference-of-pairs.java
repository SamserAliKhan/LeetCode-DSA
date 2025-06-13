import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                result = mid;      // possible, try smaller
                high = mid - 1;
            } else {
                low = mid + 1;     // not enough pairs, try bigger
            }
        }

        return result;
    }

    // Helper function to check if we can form at least p pairs
    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2;  // skip both elements to ensure non-overlapping
            } else {
                i++;     // try next element
            }
        }

        return count >= p;
    }
}
