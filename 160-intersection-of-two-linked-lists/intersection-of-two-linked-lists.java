/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        ListNode ptrA= headA;
        while(ptrA!=null){
            ptrA=ptrA.next;
            lenA++;
        }
        int lenB = 0;
        ListNode ptrB = headB;
        while (ptrB != null) {
            lenB++;
            ptrB = ptrB.next;
        }
        // Step 2: Reset the pointers back to the heads.
        ptrA = headA;
        ptrB = headB;
        // Step 3: Advance the pointer of the longer list so both are equidistant from the end.
        // This is safe because we know the exact lengths.
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                ptrA = ptrA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                ptrB = ptrB.next;
            }
        }
         // Step 4: Move both pointers together. They will either meet at the intersection
        // or both will become null at the same time.
        while (ptrA != ptrB) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return ptrA;
    }
}