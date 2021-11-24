package programmers.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NetworkTest {

    @Test
    void test() {
        Network network = new Network();
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};

        int answer = network.solution(n, computers);
        Assertions.assertThat(answer).isEqualTo(2);
    }

}