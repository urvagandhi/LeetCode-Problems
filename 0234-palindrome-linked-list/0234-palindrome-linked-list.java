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
        if (head == null || head.next == null) return true;

        // 1) Find middle (slow lands at mid; for odd length, slow at the exact middle)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If odd length, skip the middle node for comparison
        if (fast != null) slow = slow.next;

        // 2) Reverse second half
        ListNode second = reverse(slow);

        // 3) Compare first half and reversed second half
        ListNode p1 = head, p2 = second;
        boolean ok = true;
        while (p2 != null) { // second half is <= first half
            if (p1.val != p2.val) { ok = false; break; }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4) Restore the list (optional but clean)
        reverse(second);

        return ok;
    }

    // Standard in-place reverse
    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}