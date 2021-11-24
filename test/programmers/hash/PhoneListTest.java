package programmers.hash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PhoneListTest {

    @Test
    void test() {
        PhoneList phoneList = new PhoneList();

        boolean answer1 = phoneList.solution(new String[]{"119", "97674223", "1195524421"});
        Assertions.assertThat(answer1).isFalse();

        boolean answer2 = phoneList.solution(new String[]{"123","456","789"});
        Assertions.assertThat(answer2).isTrue();

        boolean answer3 = phoneList.solution(new String[]{"12","123","1235","567","88"});
        Assertions.assertThat(answer3).isFalse();

    }
}