// Some Leetcode problem in LinkedList
// Michael Ha
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// TWO POINTER IN LINKED LIST
/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        //empty linkedlist
        if(head == null)
            return false;
        //Floyd Algorithm solution
        ListNode slow;
        ListNode fast;
        
        //make both refer to the start of the list
        slow = fast = head; 
        
        while(true){
            slow = slow.next; //1 hop
            
            if (fast.next != null)
                fast = fast.next.next; //2 hops
            else
                return false;
            
            if(slow == null || fast == null){ //if either meet null, return false
                return false;
            }
            
            if(slow == fast) //if fast meet slow, there is a cycle linkedlist
                return true;
        }
        
    }

    /** Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
    Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

    Notice that you should not modify the linked list.

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.

    Input: head = [1,2], pos = 0
    Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.
    */

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false; 

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next; //1 hop
            fast = fast.next.next; //2 hop
            //check if it is cycle?
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        //if it is cycle, find that point
        if(isCycle){
            ListNode slow2 = head; 
            while (slow2 != null && slow != null) {
                if (slow2 == slow) return slow2;
                slow2 = slow2.next;
                slow = slow.next;
            }
        }
        return null;    
    }

    /**  Intersection of Two Linked Lists
     * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
     * If the two linked lists have no intersection at all, return null.
     * 
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
        Output: Intersected at '8'
        Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
        From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

        Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
        Output: Intersected at '2'
        Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
        From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null){
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a == null, assign a == headB
        while(a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }

    /** Remove Nth Node From End of List
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * 
     * Input: head = [1,2,3,4,5], n = 2
       Output: [1,2,3,5]

       Input: head = [1], n = 1
       Output: []

       Input: head = [1,2], n = 1
       Output: [1]
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next; 
    }
}