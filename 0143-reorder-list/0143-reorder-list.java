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

    // Standard in-place reverse
    private ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);

        ListNode first = head, second = headSecond;
        while (second.next != null) {
            ListNode p1 = first.next;
            ListNode p2 = second.next;

            first.next = second;
            second.next = p1;

            first = p1;
            second = p2;
        }
    }
}
