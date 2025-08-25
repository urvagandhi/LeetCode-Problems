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
    private ListNode tail; 
    private ListNode head;

    public ListNode reverseList(ListNode node) {
        if (node == null) return null;

        if (tail == null) {
            tail = node;
            while (tail.next != null) {
                tail = tail.next;
            }
        }

        if (node == tail) {
            head = tail;
            return head;
        }

        reverseList(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;

        return head;
    }
}
