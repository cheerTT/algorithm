package jianzhi.order;

import java.util.ArrayList;
import java.util.List;

public class _06_从尾到头打印链表 {

     class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

     public int[] reversePrint(ListNode head) {

         List<Integer> res = new ArrayList<>();
         reverse(head, res);

         return res.stream().mapToInt(Integer::valueOf).toArray();
     }

     public void reverse(ListNode head, List<Integer> res) {
         if (head != null) {
             reverse(head.next, res);
             res.add(head.val);
         }
     }
}
