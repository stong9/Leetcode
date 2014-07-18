/**
 * Problem Statement: Rotate List 
 * Link:https://oj.leetcode.com/problems/rotate-list/
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */


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
    public ListNode rotateRight(ListNode head, int n) {
        //special case
        if(head==null || n==0) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode head2 = dummyHead;
        
        //process n
        int count =0;
        ListNode p = head;
        while(p!=null){
            count++;
            p = p.next;
        }
        //trick
        n = count - n%count;

        //find start of second part
        for(int i=0; i<n; i++){
            head2 = head2.next;
        }
        
        //set start of second part
        //set the end of first part as null
        ListNode rnt = head2.next;
        head2.next = null;
        if(rnt==null) return dummyHead.next;
        
        //concat end of second part to the start of first part
        ListNode curr = rnt;
        while(curr.next!=null)
            curr = curr.next;
        curr.next = dummyHead.next;
        return rnt;
        
    }
}