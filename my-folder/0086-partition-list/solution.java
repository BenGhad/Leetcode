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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode less = new ListNode(-1);
        ListNode lessEnd = less;

        ListNode more = new ListNode(-1);
        ListNode moreEnd = more;

        ListNode tmp = head;
        while(tmp != null){
            if(tmp.val >= x){
                moreEnd.next = tmp;
                moreEnd = tmp;
                tmp = tmp.next;
                moreEnd.next = null;
            } else {
                lessEnd.next = tmp;
                lessEnd = tmp;
                tmp = tmp.next;
                lessEnd.next = null;
            }
        }

        less = less.next;
        more = more.next;
        lessEnd.next = more;

        return (less == null) ? more : less;
    }
}
