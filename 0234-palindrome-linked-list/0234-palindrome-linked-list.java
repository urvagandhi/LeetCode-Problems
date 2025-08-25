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
        if (head == null || head.next == null)
            return true;
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        while (headSecond != null) {
            if (head.val == headSecond.val) {
                head = head.next;
                headSecond = headSecond.next;
            } else
                return false;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        while (present != null) {
            ListNode next = present.next;
            present.next = prev;
            prev = present;
            present = next;
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
}