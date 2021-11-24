package lecture.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wedding {
    static class VisitTime implements Comparable<VisitTime> {
        int start;
        int end;

        VisitTime(int[] arr) {
            start = arr[0];
            end = arr[1];
        }

        @Override
        public int compareTo(VisitTime o) {
            if (o.end == this.end) {
                return this.start - o.start;

            } else {
                return this.end - o.end;

            }
        }

        @Override
        public String toString() {
            return String.format("{start:%d, end:%d}", start, end);
        }
    }

    public int solution(int[][] arrays) {
        List<VisitTime> times = new ArrayList<>();
        for (int[] arr: arrays) {
            times.add(new VisitTime(arr));
        }

        Collections.sort(times);
//        times.stream().forEach(System.out::println);

        int answer = 0, lastEndTime = 0;
        for (VisitTime time: times) {
            if (time.start > lastEndTime) {
                System.out.println("time = " + time);
                lastEndTime = time.end;
                answer++;
            }
        }

        return answer;
    }
}
