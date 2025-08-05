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
    public ListNode oddEvenList(ListNode head) {
        ListNode OddHead = new ListNode(-1);
        ListNode OddTail = OddHead;
        ListNode EvenHead = new ListNode(-1);
        ListNode EvenTail = EvenHead;
        ListNode curr = head;
        int i = 1;
        while(curr!=null){
            //Odd nodes
            if(i%2 !=0){
                OddTail.next = curr;
                OddTail = OddTail.next;
            }
            //Even nodes
            else{
                EvenTail.next = curr;
                EvenTail = EvenTail.next;
            }
            i++;
            curr = curr.next;
        }
        EvenTail.next = null;
        OddTail.next = EvenHead.next;
        return OddHead.next;
    }
}