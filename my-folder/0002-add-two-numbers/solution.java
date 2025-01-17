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
        ListNode ans = l1;

        ListNode node = ans;
        while(l2 != null){
            node.val += l2.val;
            if(node.next == null && l2.next != null){
                node.next = new ListNode(0);
            }
            node = node.next;
            l2 = l2.next;
        }

        node = ans;
        while(node != null){
            if(node.val >= 10){
                node.val -= 10;
                if(node.next == null){
                    node.next = new ListNode(1);
                } else {
                    node.next.val += 1;
                }
            }
            node = node.next;
        }

        return ans;
    }
}
