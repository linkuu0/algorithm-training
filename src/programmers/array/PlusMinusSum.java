package programmers.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class PlusMinusSum {
    public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length)
                .map(i -> signs[i] ? absolutes[i] : absolutes[i] * -1)
                .sum();
    }

    @Test
    void test() {
        PlusMinusSum plusMinusSum = new PlusMinusSum();
        int answer1 = plusMinusSum.solution(new int[]{4,7,12}, new boolean[]{true, false, true});
        Assertions.assertThat(answer1).isEqualTo(9);

        int answer2 = plusMinusSum.solution(new int[]{1,2,3}, new boolean[]{false, false, true});
        Assertions.assertThat(answer2).isEqualTo(0);
    }
}
