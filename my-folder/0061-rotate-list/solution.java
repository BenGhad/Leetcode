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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        int length = 1;
        ListNode dummy = head;
        
        while(dummy.next != null){
            length++;
            dummy = dummy.next;
        }

        dummy.next = head;
        k = k % length;

        for(int i = 0; i < length - k - 1; i++){
            head = head.next;
        }

        dummy = head.next;
        head.next = null;
        return dummy;
    }
}
