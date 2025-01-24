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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode second = head;
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        if(first.next != null) first.next = first.next.next;

        return head;
    }
}
