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

 /**
  * Given the head of a singly linked list, reverse the list, and return the reversed list.
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

  */ 
class Solution {
    public ListNode reverseList(ListNode head) {
        //boundary case
        if(head == null) return null;
        
        ListNode current, prev, next;
        current = head;
        prev = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /**
     * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
    Input: head = [], val = 1
    Output: []
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return head;
    }

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

    The first node is considered odd, and the second node is even, and so on.

    Note that the relative order inside both the even and odd groups should remain as it was in the input.

    You must solve the problem in O(1) extra space complexity and O(n) time complexity.

    Input: head = [1,2,3,4,5]
    Output: [1,3,5,2,4]

    Input: head = [2,1,3,5,6,4,7]
    Output: [2,3,6,7,1,5,4]
 */

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    /**
     * Given the head of a singly linked list, return true if it is a palindrome.
     * Input: head = [1,2,2,1]
       Output: true

       Input: head = [1,2]
       Output: false
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stk=new Stack<>();
        
        ListNode temp=head;
        
        while(temp!=null)
        {
            stk.push(temp);
            temp=temp.next;
        }
        
        while(head!=null && !stk.isEmpty())
        {
            if(stk.pop().val != head.val)
            {
                return false;
            }
            head=head.next;
        }
        
        return true;
    }
}