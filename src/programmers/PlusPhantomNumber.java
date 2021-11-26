package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PlusPhantomNumber {
    public int solution(int[] numbers) {
        assert numbers.length >= 1;
        assert numbers.length <= 9;

        return 45 - Arrays.stream(numbers).sum();
    }

    @Test
    void test() {
        PlusPhantomNumber plusPhantomNumber = new PlusPhantomNumber();
        int answer1 = plusPhantomNumber.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0});
        Assertions.assertThat(answer1).isEqualTo(14);

        int answer2 = plusPhantomNumber.solution(new int[]{5,8,4,0,6,7,9});
        Assertions.assertThat(answer2).isEqualTo(6);

    }
}
