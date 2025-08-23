/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int lengthCycle(ListNode slow) {
        ListNode curr = slow;
        int length = 0;
        do {
            curr = curr.next;
            length++;
        } while (curr != slow);
        return length;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) return null;
        
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }
        while (f != s) {
            f  = f.next;
            s = s.next;
        }
        return s;
    }
}