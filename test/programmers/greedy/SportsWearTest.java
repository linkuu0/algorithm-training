package programmers.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SportsWearTest {

    @Test
    void test() {
        SportsWear sportsWear = new SportsWear();

        int answer1 = sportsWear.solution(5, new int[]{2,4}, new int[]{1,3,5});
        Assertions.assertThat(answer1).isEqualTo(5);

        int answer2 = sportsWear.solution(5, new int[]{2,4}, new int[]{3});
        Assertions.assertThat(answer2).isEqualTo(4);

        int answer3 = sportsWear.solution(3, new int[]{3}, new int[]{1});
        Assertions.assertThat(answer3).isEqualTo(2);

    }

}