package programmers.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StockPriceTest {
    @Test
    void test() {
        StockPrice stockPrice = new StockPrice();
        int[] answer = stockPrice.solution(new int[]{1,2,3,2,3});

        Assertions.assertThat(answer).isEqualTo(new int[]{4,3,1,1,0});
    }
}