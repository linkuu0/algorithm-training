package leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode();
        ListNode last = head;
        ListNode p;

        while (list1 != null && list2 != null) {
            p = new ListNode();
            if (list1.val < list2.val) {
                p.val = list1.val;
                list1 = list1.next;

            } else {
                p.val = list2.val;
                list2 = list2.next;

            }

            last.next = p;
            last = last.next;
        }

        if (list1 == null) {
            last.next = list2;  // 전부 다 붙여줘야함
        }

        if (list2 == null) {
            last.next = list1;  // 전부 다 붙여줘야함
        }

        return head.next;

    }

    @Test
    void test() {
        ListNode answer = mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4));
        Assertions.assertThat(answer).isEqualTo(ListNode.of(1, 1, 2, 3, 4, 4));
    }

    @Test
    void test2() {
        ListNode answer = mergeTwoLists(ListNode.of(-9, 3), ListNode.of(5, 7));
        Assertions.assertThat(answer).isEqualTo(ListNode.of(-9, 3, 5, 7));
    }
}
