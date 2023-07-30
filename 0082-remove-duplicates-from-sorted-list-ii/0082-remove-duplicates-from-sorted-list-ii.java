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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode prev = res;

        while (head != null) {
            boolean duplicate = false;
            while (head != null && head.next != null && head.val == head.next.val) {
               // System.out.println(head.val);
                head = head.next;
                duplicate = true;
            }
            if (duplicate) {
                prev.next = head.next;
            } else {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        
        }
        return res.next;
    }
}