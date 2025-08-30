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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        // Either initialize length = 1 and loop while temp.next != null,
        //  or keep length = 0 but loop while temp != null.
        int length = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }

        for(int i = 0; i < k%length; i++){
            ListNode present =  head;
            ListNode previous = null;

            while(present.next != null){
                previous = present;
                present = present.next;
            }

            present.next = head;
            previous.next = null;
            head = present;
        }
        return head;
    }
}