package programmers.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeBigNumberTest {

    @Test
    void test() {
        MakeBigNumber makeBigNumber = new MakeBigNumber();

        String answer1 = makeBigNumber.solution("1924", 2);
        Assertions.assertThat(answer1).isEqualTo("94");

        String answer2 = makeBigNumber.solution("1231234", 3);
        Assertions.assertThat(answer2).isEqualTo("3234");

        String answer3 = makeBigNumber.solution("4177252841", 4);
        Assertions.assertThat(answer3).isEqualTo("775841");

    }

}