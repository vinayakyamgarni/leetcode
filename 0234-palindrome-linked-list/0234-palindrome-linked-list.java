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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

       
        if (fast != null) {
            slow = slow.next;
        }

     
        ListNode second = reverseList(slow);
        ListNode first = head;

       
        while (second != null) {
            if (first.val != second.val)
                return false;

            first = first.next;
            second = second.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prv = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prv;
            prv = curr;
            curr = temp;
        }

        return prv;
    }
}