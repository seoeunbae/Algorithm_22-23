package solved;

import java.util.List;

public class MergeTwoLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoList(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode firstNode = new ListNode(0);
        ListNode nextNode = firstNode;

        while(list1 != null && list2 != null){
            if (list1.val > list2.val) {
                nextNode.next = list2;
                list2 = list2.next;
            } else {
                nextNode.next = list1;
                list1 = list1.next;
            }
            nextNode = nextNode.next;
        }

        if (list1 == null) {
            nextNode.next = list2;
        }
        if (list2 == null) {
            nextNode.next = list1;
        }

        return firstNode.next;
    }
}
