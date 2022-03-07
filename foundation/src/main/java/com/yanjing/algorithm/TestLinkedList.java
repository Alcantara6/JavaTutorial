package com.yanjing.algorithm;

/**
 * @author yanjing
 * @date 2022/1/3
 */
public class TestLinkedList {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.setNext(new ListNode(4));
        l1.getNext().setNext(new ListNode(3));
        ListNode l2 = new ListNode(5);
        l2.setNext(new ListNode(6));
        l2.getNext().setNext(new ListNode(4));
        System.out.println("addTwoNumbers: " + addTwoNumbers(l1, l2).toStringReverse());
        System.out.println("reverseList: " + reverseList(l1));
        System.out.println("getKthFromEnd: " + getKthFromEnd(l2, 2));
        System.out.println("delKthFromEnd： " + delKthFromEnd(l2, 2));
    }

    /**
     * 两数相加，按为相加和进位
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int n1 = l1 != null ? l1.getVal() : 0;
            int n2 = l2 != null ? l2.getVal() : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {

                head = tail = new ListNode(sum % 10);
            } else {

                tail.setNext(new ListNode(sum % 10));
                tail = tail.getNext();
            }
            carry = sum / 10;
            if (l1 != null) {

                l1 = l1.getNext();
            }
            if (l2 != null) {

                l2 = l2.getNext();
            }
        }
        // 注意最后进位
        if (carry > 0) {

            tail.setNext(new ListNode(carry));
        }
        return head;
    }

    /**
     * 反转链表，迭代法
     * 主要是对prev和next进行缓存
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {

            ListNode nextTmp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    /**
     * 倒数第K个节点，双指针，不用统计链表长度
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {

        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i < k; i++) {
            former = former.getNext();
        }
        while (former != null) {

            former = former.getNext();
            latter = latter.getNext();
        }
        return latter;
    }

    /**
     * 双指针法，删除倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode delKthFromEnd(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.setNext(head);
        ListNode former = head;
        ListNode latter = dummy;
        for (int i = 0; i < k; i++) {
            former = former.getNext();
        }
        while (former != null) {

            former = former.getNext();
            latter = latter.getNext();
        }
        latter.setNext(latter.getNext().getNext());
        return head;
    }
}

class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        sb.append(curr.getVal());
        while (curr.getNext() != null) {

            curr = curr.getNext();
            sb.append(curr.getVal());
        }
        return sb.toString();
    }

    public String toStringReverse() {

        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        sb.append(curr.getVal());
        while (curr.getNext() != null) {

            curr = curr.getNext();
            sb.append(curr.getVal());
        }
        return sb.reverse().toString();
    }
}