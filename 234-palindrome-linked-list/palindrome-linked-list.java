/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)return true;
        //Optimal Sollution using fast and slow then reversing the second half.
        //Then checking form the head of the reversed half and the original half.
        ListNode slow=head;
        ListNode fast=head;
        //finding the end of the first half
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //now slow is pointing to the exact middle node of the LL
        //reversing the second half of the linked list
        ListNode newHead=reverse(slow.next);

        //comparing the 2 halfs of the linedlist
        while(newHead != null){
            if(newHead.val != head.val)return false;
            newHead = newHead.next;
            head = head.next;
        }
        return true;
        
    }
    ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}