package programmers.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrinterTest {

    @Test
    void test() {
        Printer printer = new Printer();
        int answer = printer.solution(new int[]{2,1,3,2}, 2);

        Assertions.assertThat(answer).isEqualTo(1);
    }

}