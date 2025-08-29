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

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode deleteMiddle(ListNode head) {
        
        if(head.next == null) return head.next;
        if(head.next.next == null){
            head.next = null;
            return head;
        }
        
        ListNode middle = middleNode(head);
        if(middle.next != null){
            middle.val = middle.next.val;
            middle.next = middle.next.next;
        } else middle.next = null;

        return head;
    }
}