package programmers.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TravelPathTest {
    @Test
    void test() {
        TravelPath travelPath = new TravelPath();
        String[] answer = travelPath.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});

        System.out.println("answer = " + Arrays.toString(answer));
        Assertions.assertThat(answer).isEqualTo(new String[]{"ICN", "JFK", "HND", "IAD"});
    }

}