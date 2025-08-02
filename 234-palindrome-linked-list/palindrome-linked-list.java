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
        //Brute Force approch using stack
        
        Stack <Integer> st = new Stack<>();
        ListNode ptr = head;
        int temp;
        while(ptr!=null){
            st.push(ptr.val);
            ptr = ptr.next;
        }
        ptr = head;
        while(ptr!=null){
            temp = st.pop();
            if(temp!=ptr.val)return false;
            ptr = ptr.next;
        }
        return true;
    }
}