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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(l1 != null || l2!=null) {
            if(l1 == null) {
                sum = l2.val + carry;
                carry = sum / 10;
                dummy.next = new ListNode(sum % 10);
                dummy = dummy.next;
                l2 = l2.next;
            }
            else if(l2 == null) {
                sum = l1.val + carry;
                carry = sum / 10;
                dummy.next = new ListNode(sum % 10);
                dummy = dummy.next;
                l1 = l1.next;
            }
            else {
                sum = l1.val + l2.val + carry;
                carry = sum / 10;
                dummy.next = new ListNode(sum % 10);
                dummy = dummy.next;
                l2 = l2.next;
                l1 = l1.next;
            }
        }
        
        if(carry > 0) {
            dummy.next = new ListNode(carry);
            carry = 0;
        }
        return head.next;
    }
}