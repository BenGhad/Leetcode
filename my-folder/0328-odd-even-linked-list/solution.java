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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(odd != null && even != null){
            if(even.next != null){
                ListNode nextEven = even.next.next;
                odd.next = odd.next.next;
                even.next = nextEven;
                odd = odd.next;
                even = even.next;
            } else {
                break;
            }

        }
        odd.next = evenHead;
        return head;
    }

}
