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
    public ListNode findMid(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode margeSort(ListNode head){
        if(head==null || head.next == null)return head;
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;
        ListNode leftSorted = margeSort(head);
        ListNode rightSorted = margeSort(right);
        return marge(leftSorted,rightSorted);
    }
    public ListNode marge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(list1 !=null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null){
            curr.next = list1;
        }
        else{
            curr.next = list2;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null)return null;
        ListNode newHead = margeSort(head);
        return newHead;
    }
}