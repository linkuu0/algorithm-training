package programmers.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TrunkOnBridgeTest {
    @Test
    void test() {
        TrunkOnBridge trunkOnBridge = new TrunkOnBridge();
        int answer = trunkOnBridge.solution(2, 10, new int[]{7, 4, 5, 6});

        Assertions.assertThat(answer).isEqualTo(8);
    }
}