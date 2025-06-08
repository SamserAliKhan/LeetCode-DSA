class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Number of elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Overwrite with non-val element
                k++;
            }
        }

        return k; // First k elements are valid, rest don't matter
    }
}
