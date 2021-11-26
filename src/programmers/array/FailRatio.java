package programmers.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailRatio {
    static class Stage implements Comparable<Stage> {
        int stage;
        double ratio;

        Stage (int stage, double ratio) {
            this.stage = stage;
            this.ratio = ratio;
        }

        @Override
        public int compareTo(Stage o) {
            if (o.ratio == this.ratio) {
                return this.stage - o.stage;
            }

            return Double.compare(o.ratio, this.ratio);
        }
    }

    public int[] solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>();

        int[] totalUser = new int[N+1];
        int[] failUser = new int[N+1];

        // 스테이지 실패인원 세팅
        for (int stage : stages) {
            failUser[stage - 1]++;
        }

        // 전체 수 세팅
        totalUser[N] = failUser[N-1] + failUser[N];
        for (int i=N; i>0; i--) {
            totalUser[i-1] = totalUser[i] + failUser[i-1];
        }

        for (int i=0; i<N; i++) {
            if (failUser[i] == 0) {
                stageList.add(new Stage(i+1, 0));
            } else {
                stageList.add(new Stage(i+1, (double) failUser[i] / totalUser[i]));
            }
        }

        Collections.sort(stageList);

        return stageList.stream()
                .mapToInt(stage -> stage.stage)
                .toArray();
    }

    @Test
    void test() {
        int[] answer1 = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        Assertions.assertThat(answer1).isEqualTo(new int[]{3, 4, 2, 1, 5});

        int[] answer2 = solution(4, new int[]{4, 4, 4, 4, 4});
        Assertions.assertThat(answer2).isEqualTo(new int[]{4, 1, 2, 3});
    }
}
