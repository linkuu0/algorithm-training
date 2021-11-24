package programmers.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConvertWordTest {

    @Test
    void test() {
        ConvertWord convertWord = new ConvertWord();
        int answer = convertWord.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        Assertions.assertThat(answer).isEqualTo(4);
    }

}