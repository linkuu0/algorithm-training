package programmers.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LifeBoatTest {

    @Test
    void test() {
        LifeBoat lifeBoat = new LifeBoat();
        int answer1 = lifeBoat.solution(new int[]{70, 50, 80, 50}, 100);
        Assertions.assertThat(answer1).isEqualTo(3);

        int answer2 = lifeBoat.solution(new int[]{70, 80, 50}, 100);
        Assertions.assertThat(answer2).isEqualTo(3);
    }

}