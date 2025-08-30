/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int length(ListNode temp){
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int length1 = length(headA);
        int length2 = length(headB);

        ListNode check1 = headA;
        ListNode check2 = headB;
        while(length1 > 0 && length2 > 0){
            if(check1 == check2){
                return check1;
            }
            else{
                if(length1>length2){
                    check1 = check1.next;
                    length1--;
                }else if(length1 < length2){
                    check2 = check2.next;
                    length2--;
                } else{
                    check1 = check1.next;
                    check2 = check2.next;
                    length1--;
                    length2--;
                }
            }
        }

        return null;
    }
}