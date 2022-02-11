package leetcode.LinkedList;

/*
* 21. Merge Two Sorted Lists
* https://leetcode.com/problems/merge-two-sorted-lists/
* */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {

    public ListNode mergeTwoListsIteratively(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = new ListNode(-1);

        ListNode tail = head;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;

        return head.next;
    }

    public ListNode mergeTwoListsRecursively(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val <= list2.val){
            list1.next = mergeTwoListsRecursively(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursively(list1, list2.next);
            return list2;
        }

    }

}
