class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prevTail = null;
        while (curr != null) {
            ListNode kthNode = getKthNode(curr, k);
            if (kthNode == null) {
                if (prevTail != null) prevTail.next = curr;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            ListNode rev = reverseList(curr);
            if (curr == head) head = rev;
            else prevTail.next = rev;
            prevTail = curr;
            curr.next = nextNode;
            curr = nextNode;
        }
        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode head, int k) {
        ListNode curr = head;
        while (curr != null && --k > 0) curr = curr.next;
        return curr;
    }
}