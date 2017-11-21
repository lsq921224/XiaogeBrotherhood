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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(lists.length,new com());
        for(ListNode list:lists){
            if(list!=null)
                pq.add(list);
        }
        ListNode dummy=new ListNode(-1);
        ListNode node=dummy;
        while(!pq.isEmpty()){
            node.next=pq.remove();
            node=node.next;//This position is important
            if(node.next!=null)
                pq.add(node.next);

        }
        return dummy.next;
	}
	public class com implements Comparator<ListNode>{
	    public int compare(ListNode l1, ListNode l2){
	        return l1.val-l2.val;
	    }
	}
}
