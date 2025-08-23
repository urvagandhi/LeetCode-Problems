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
        int length = lengthLL(head);
        int index = length/2;

        System.out.println(index);

        ListNode temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public int lengthLL(ListNode head) {
        int length = 0;
        if (head == null)
            return length;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        length++;
        return length;
    }
}