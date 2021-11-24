package programmers.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FeatureDevelopment {

    // 배열을 활용한 구현
    public int[] solution(int[] progresses, int[] speeds) {
        int[] finishJobPerDay = new int[100];
        int day = 0;

        for (int i=0; i<progresses.length; i++) {
            while (progresses[i] + (speeds[i] * day) < 100) {
                day++;
            }

            finishJobPerDay[day]++;
        }

        return Arrays.stream(finishJobPerDay)
                .filter(value -> value != 0)
                .toArray();
    }

    // Queue를 활용한 구현
    public int[] solutionUsingQueue(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int[] finishJobPerDay = new int[100];
        int remainProgress, day;

        for (int i=0; i<speeds.length; i++) {
            remainProgress = 100 - progresses[i];

            day = remainProgress / speeds[i];
            int e = remainProgress % speeds[i] > 0 ? day + 1 : day;
            queue.offer(e);
        }

        int time = 0, count = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek() <= time) {
                queue.poll();
                count++;
            }

            finishJobPerDay[time++] = count;
        }

        return Arrays.stream(finishJobPerDay)
                .filter(value -> value != 0)
                .toArray();
    }

    public static void main(String[] args) {
        FeatureDevelopment featureDevelopment = new FeatureDevelopment();

        int[] answer = featureDevelopment.solutionUsingQueue(new int[]{93,30,55}, new int[]{1,30,5});
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
