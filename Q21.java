//21. Merge Two Sorted Lists

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //edge case
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1 == null && list2 == null) return null;
        
        ListNode newList = new ListNode(-1);
        //pointer!
        ListNode cur = newList;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else{//list1>list2
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
            if(list1 == null){
                cur.next = list2;
            }
            if(list2 == null){
                cur.next = list1;
            }
        }
        return newList.next;
    }
}