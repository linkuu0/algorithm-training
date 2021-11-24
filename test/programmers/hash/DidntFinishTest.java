package programmers.hash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DidntFinishTest {

    @Test
    void test() {
        DidntFinish didntFinish = new DidntFinish();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};

        String answer = didntFinish.solution(participant, completion);
        Assertions.assertThat(answer).isEqualTo("leo");
    }

}