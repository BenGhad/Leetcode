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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        
        int len = 0;
        while(dummy != null){
            len++;
            dummy = dummy.next;
        }
        if(len == n){
            return head.next;
        }
        dummy = head;
        for(int i = 0; i < (len - n - 1); i++){
            dummy = dummy.next;
        }

        if(dummy != null && dummy.next != null){
            dummy.next = dummy.next.next;
        }
        return head;
    }
}
