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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null) return head;
        
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        //use pointer p to delete repeat value
        ListNode p = head;
        int del = 0;
        
        while(p!=null && p.next!=null){
            if(p.val==p.next.val){
                del = p.val;
                //delete repete listNode
                while(p.val==del){
                    p = p.next;
                     if(p==null) 
                        return dummyHead.next;
                }
               
            }
            else{
                pre.next = p;
                pre = pre.next;
                p = p.next;
                //need to set next as null, otherwise, its next will be nodes in original list
                pre.next = null;
            }
                
        }
        
        pre.next = p;
        return dummyHead.next;
        
     
        
        
    }
}