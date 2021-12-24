package leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int len = needle.length();

        for (int i=0; i<haystack.length()-len+1; i++) {
            if (needle.equals(haystack.substring(i, i+len))) {
                return i;
            }
        }

        return -1;
    }

    @Test
    void test() {
        Assertions.assertThat(strStr("hello", "ll")).isEqualTo(2);
    }
}
