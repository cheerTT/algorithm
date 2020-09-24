package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class _03 {
     /*测试用例依次为 链表数目为3 单个链表长度分别为2、3、4，以及每个节点长度
     3 2 3 4
     1:2 2:3
     3:4 2:7 4:3
     7:3 9:1 4:3 12:2*/

    public static void main(String[] args) throws IOException {
        ListNode[] listNodes = scannrValue();
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i]=sortSingleList(listNodes[i]);
        }
        ListNode head = mergeKLists(listNodes);

        //输出检验
        int count = 0;
        while (head != null) {
            System.out.println("count: " + (++count) + " key: " + head.key + " val: " + head.val);
            head = head.next;
        }
    }

    //扫描输入
    private static ListNode[] scannrValue() {
        Scanner sc = new Scanner(System.in);
        int linkedListNum = sc.nextInt();//链表数目
        int[] linkedListLength = new int[linkedListNum];
        for (int i = 0; i < linkedListNum; i++) {
            //保存每个链表长度
            linkedListLength[i] = sc.nextInt();
        }

        //节点解析，并将每个链表头结点保存在ListNode[]数组中
        ListNode[] listNodes = new ListNode[linkedListNum];
        for (int i = 0; i < linkedListNum; i++) {
            ListNode dummy = new ListNode(0, 0);
            ListNode cur = dummy;
            dummy.next = cur;
            for (int j = 0; j < linkedListLength[i]; j++) {
                //节点解析
                String[] str = sc.next().split(":");
                ListNode temp = new ListNode(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                cur.next = temp;
                cur = temp;
            }
            //添加头结点
            listNodes[i] = dummy.next;
        }
        return listNodes;
    }

    //采用归并进行链表排序
    public static ListNode sortSingleList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;//这两步顺序很重要
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortSingleList(head), sortSingleList(slow));
    }

    //输入两个链表头节点，返回合并后头节点
    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode cur = null;
        if (l1.key == l2.key) {
            l1.next = merge(l1.next, l2.next);
            l1.val +=l2.val;
            cur = l1;
        }
        if (l1.key < l2.key) {
            l1.next = merge(l1.next, l2);
            cur = l1;
        }
        if (l1.key > l2.key) {
            l2.next = merge(l1, l2.next);
            cur = l2;
        }
        return cur;
    }

    //n个链表合并
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return merge(lists[0], lists[1]);

        return merge(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)),
                mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));
    }

    //节点定义
    static class ListNode {
        //模拟包含键值对类型链表
        private int key;
        private int val;
        private ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
