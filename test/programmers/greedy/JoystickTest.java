package programmers.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JoystickTest {

    @Test
    void test() {
        Joystick joystick = new Joystick();

        int answer1 = joystick.solution("JEROEN");
        Assertions.assertThat(answer1).isEqualTo(56);

        int answer2 = joystick.solution("JAN");
        Assertions.assertThat(answer2).isEqualTo(23);

    }

}