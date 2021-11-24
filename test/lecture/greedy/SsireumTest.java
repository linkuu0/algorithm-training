package lecture.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SsireumTest {

    @Test
    void test() {
        Ssireum ssireum = new Ssireum();
        int[][] players = new int[][] {{172,67}, {183,65}, {180,70}, {170,72}, {181,60}};
        int answer = ssireum.solution(players);
        System.out.println("answer = " + answer);

        Assertions.assertThat(answer).isEqualTo(3);
    }
}