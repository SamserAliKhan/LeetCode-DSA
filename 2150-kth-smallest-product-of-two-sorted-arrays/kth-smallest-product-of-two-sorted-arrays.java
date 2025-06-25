class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -100_000L * 100_000L - 1;
        long right = 100_000L * 100_000L + 1;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessEqual(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private long countLessEqual(int[] A, int[] B, long x) {
        long count = 0;
        for (int a : A) {
            if (a > 0) {
                // B[j] ≤ x / a → binary search upper_bound in B
                int lo = 0, hi = B.length;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if ((long)a * B[mid] <= x) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                count += lo;
            } else if (a < 0) {
                // B[j] ≥ ceil(x / a) → binary search lower_bound in B
                int lo = 0, hi = B.length;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if ((long)a * B[mid] <= x) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                count += (B.length - lo);
            } else {
                if (x >= 0) count += B.length;
            }
        }
        return count;
    }
}
