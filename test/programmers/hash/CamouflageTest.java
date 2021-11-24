package programmers.hash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CamouflageTest {

    @Test
    void test() {
        Camouflage camouflage = new Camouflage();
        String[][] clothes = new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        int answer = camouflage.solution(clothes);
        Assertions.assertThat(answer).isEqualTo(5);
    }
}