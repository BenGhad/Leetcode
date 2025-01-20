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
            ListNode node = pq.poll();
            if(node.next != null) pq.offer(node.next);
            current.next = node;
            current = current.next;
        }

        return dummy.next;

    }
}
