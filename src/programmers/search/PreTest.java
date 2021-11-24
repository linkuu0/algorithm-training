package programmers.search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PreTest {

    public int[] solution(int[] answers) {
        int[] correct = new int[3];
        int[][] pattern = new int[3][];

        pattern[0] = new int[]{1,2,3,4,5};
        pattern[1] = new int[]{2,1,2,3,2,4,2,5};
        pattern[2] = new int[]{3,3,1,1,2,2,4,4,5,5};

        for (int i=0; i<answers.length; i++) {
            for (int j=0; j<pattern.length; j++) {
                if (pattern[j][i % pattern[j].length] == answers[i])
                    correct[j]++;
            }
        }

        return IntStream.range(0, correct.length)
                .filter(index -> correct[index] == Arrays.stream(correct).max().getAsInt())
                .map(index -> index + 1)
                .toArray();
    }

    public static void main(String[] args) {
        PreTest preTest = new PreTest();
        int[] answer = preTest.solution(new int[]{1, 2, 3, 4, 5});

        System.out.println("answer = " + Arrays.toString(answer));
    }
}
