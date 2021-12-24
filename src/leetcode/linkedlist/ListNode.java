package leetcode.linkedlist;

import java.util.Objects;

public class ListNode {
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

    static ListNode of(int... integers) {
        if (integers == null || integers.length == 0)
            throw new IllegalArgumentException();

        ListNode head = new ListNode();
        ListNode last = head;
        ListNode p;

        for (int i: integers) {
            p = new ListNode(i);
            last.next = p;
            last = last.next;
        }

        return head.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;

        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
