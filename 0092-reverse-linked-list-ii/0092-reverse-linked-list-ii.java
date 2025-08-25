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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = null;
        ListNode start1 = null;
        int index = 1;

        while (index < left) {
            start1 = present;
            prev = present;
            present = present.next;
            index++;
        }

        ListNode start = present;
        next = present.next;

        while (index <= right) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) next = next.next;
            index++;
        }

        if (start1 != null) {
            start1.next = prev;
        } else {
            head = prev;
        }

        start.next = present;

        return head;
    }
}
