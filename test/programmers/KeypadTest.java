package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import programmers.array.Keypad;

class KeypadTest {

    @Test
    void test() {
        Keypad keypad = new Keypad();

        String answer = keypad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        Assertions.assertThat(answer).isEqualTo("LRLLLRLLRRL");

        String answer2 = keypad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        Assertions.assertThat(answer2).isEqualTo("LRLLRRLLLRR");

        String answer3 = keypad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
        Assertions.assertThat(answer3).isEqualTo("LLRLLRLLRL");

    }

}