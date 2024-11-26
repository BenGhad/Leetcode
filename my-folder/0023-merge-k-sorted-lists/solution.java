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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(ListNode l : lists){
            if(l != null) pq.offer(l);
        }

        while(!pq.isEmpty()){
            ListNode small = pq.poll();
            current.next = small;
            current = current.next;
            if(small.next != null){
                pq.offer(small.next);
            }
        }


        return dummy.next;
        

    }
}
