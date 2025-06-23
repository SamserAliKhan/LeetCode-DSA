import java.util.ArrayList;
import java.util.List;

class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1; // Current length of the base-10 palindrome we are trying to generate

        // We will generate palindromes by their 'half' part
        // Example: for length 3, half part could be 1, 2, ..., 9, 10, 11, ... 99
        // for '1', palindrome is 1 (odd)
        // for '10', palindrome is 101 (odd)
        // for '1', palindrome is 11 (even)
        // for '10', palindrome is 1001 (even)

        while (count < n) {
            // Generate even length palindromes
            // The first half goes from 10^(len/2 - 1) to 10^(len/2) - 1
            // For len=1, no even palindromes.
            // For len=2, firstHalf starts from 1. (e.g., 1 -> 11, 2 -> 22, ..., 9 -> 99)
            // For len=4, firstHalf starts from 10. (e.g., 10 -> 1001, 11 -> 1111)
            if (len % 2 == 0) {
                long startHalf = (len == 0) ? 1 : (long) Math.pow(10, len / 2 - 1);
                long endHalf = (long) Math.pow(10, len / 2);

                for (long half = startHalf; half < endHalf && count < n; half++) {
                    String sHalf = String.valueOf(half);
                    String reversedSHalf = new StringBuilder(sHalf).reverse().toString();
                    long num = Long.parseLong(sHalf + reversedSHalf);

                    if (isPalindrome(num, k)) {
                        sum += num;
                        count++;
                    }
                }
            }

            // Generate odd length palindromes
            // The first half (including middle digit) goes from 10^(len/2) to 10^((len+1)/2) - 1
            // For len=1, firstHalf starts from 1. (e.g., 1 -> 1, 2 -> 2, ..., 9 -> 9)
            // For len=3, firstHalf starts from 10. (e.g., 10 -> 101, 11 -> 111)
            // For len=5, firstHalf starts from 100. (e.g., 100 -> 10001, 101 -> 10101)
            if (len % 2 != 0 || len == 1) { // len == 1 is essentially an odd length
                long startHalf = (long) Math.pow(10, len / 2); // For len=1, startHalf=1
                long endHalf = (long) Math.pow(10, (len + 1) / 2);

                for (long half = startHalf; half < endHalf && count < n; half++) {
                    String sHalf = String.valueOf(half);
                    String reversedSHalf = new StringBuilder(sHalf.substring(0, sHalf.length() - 1)).reverse().toString();
                    long num = Long.parseLong(sHalf + reversedSHalf);

                    if (isPalindrome(num, k)) {
                        sum += num;
                        count++;
                    }
                }
            }

            len++; // Move to the next length for base-10 palindromes
        }

        return sum;
    }

    // Helper function to check if a number is a palindrome in a given base
    private boolean isPalindrome(long num, int base) {
        if (num == 0) return true; // 0 is a palindrome

        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add((int) (num % base));
            num /= base;
        }

        int left = 0;
        int right = digits.size() - 1;
        while (left < right) {
            if (!digits.get(left).equals(digits.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}