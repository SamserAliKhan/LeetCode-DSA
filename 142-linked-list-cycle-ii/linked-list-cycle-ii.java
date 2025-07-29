public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Find the meeting point inside the cycle.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // A cycle is detected.
            if (slow == fast) {
                // Phase 2: Find the start of the cycle.
                slow = head; // Reset slow to the head.
                
                // Move both pointers one step at a time until they meet.
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // The meeting point is the start of the cycle.
                return slow;
            }
        }

        // If the loop finishes, fast reached the end, so no cycle exists.
        return null;
    }
}