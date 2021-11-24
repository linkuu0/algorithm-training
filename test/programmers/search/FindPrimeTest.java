package programmers.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FindPrimeTest {
    @Test
    void test() {
        FindPrime findPrime = new FindPrime();
        int answer = findPrime.solution("15");

        Assertions.assertThat(answer).isEqualTo(1);
    }

}