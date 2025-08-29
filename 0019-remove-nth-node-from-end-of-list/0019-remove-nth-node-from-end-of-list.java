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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        if(n == length) return head.next;

        temp = head;
        int count = length - n;
        while(count > 1){
            temp = temp.next;
            count--;
        }
        
        temp.next = temp.next.next;

        return head;
    }
}