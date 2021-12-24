package leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode last = head;
        ListNode pickle = head;

        for (int i=0; i<n; i++) {
            last = last.next;
        }

        if (last == null)
            return head.next;

        while (last.next != null) {
            last = last.next;
            pickle = pickle.next;
        }

        pickle.next = pickle.next.next;

        return head;
    }

    @Test
    void test() {
        ListNode answer = removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2);
        Assertions.assertThat(answer).isEqualTo(ListNode.of(1, 2, 3, 5));

    }
}
