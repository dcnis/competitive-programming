package LinkedList;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);

        reverseBetween(start, 2, 4);

        System.out.println("expected: 14325");
        while(start != null){
            System.out.print(start.val);
            start = start.next;
        }
        System.out.println();

        start = new ListNode(0);
        start.next = new ListNode(1);
        start.next.next = new ListNode(2);
        start.next.next.next = new ListNode(3);
        start.next.next.next.next = new ListNode(4);
        start.next.next.next.next.next = new ListNode(5);
        start.next.next.next.next.next.next = new ListNode(6);
        start.next.next.next.next.next.next.next = new ListNode(7);
        start.next.next.next.next.next.next.next.next = new ListNode(8);

        reverseBetween(start, 4, 5);

        System.out.println("expected:");
        System.out.println("012435678");
        while(start != null){
            System.out.print(start.val);
            start = start.next;
        }
        System.out.println();

        start = new ListNode(4);
        start.next = new ListNode(5);
        start.next.next = new ListNode(6);

        reverseBetween(start, 1, 3);

        System.out.println("expected:");
        System.out.println("654");
        while(start != null){
            System.out.print(start.val);
            start = start.next;
        }
        System.out.println();

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        ListNode tail = curr;

        ListNode p0 = null;
        ListNode p1 = curr;
        ListNode p2 = null;

        while(right > 0){
            p2 = p1.next;
            p1.next = p0;
            p0 = p1;
            p1 = p2;
            right--;
        }

        tail.next = p1;
        if(prev == null){
            head = p0;
        } else {
            prev.next = p0;
        }

        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
