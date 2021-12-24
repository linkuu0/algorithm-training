package leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode();
        ListNode node = root;
        System.out.println("node = " + head);

        int cnt = 0;
        int temp = -1;

        while (head != null) {
            if (++cnt % 2 == 0) {
                node.next = new ListNode(head.val, new ListNode(temp));
                node = node.next.next;
                temp = -1;

            } else {
                temp = head.val;

            }

            head = head.next;
        }

        if (temp > -1) {
            node.next = new ListNode(temp);
        }

        return root.next;
    }

    @Test
    void test() {
        ListNode answer = swapPairs(ListNode.of(1, 2, 3, 4, 5));
        Assertions.assertThat(answer).isEqualTo(ListNode.of(2, 1, 4, 3, 5));
    }
}
