package lecture.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoom {
    static class MeetingTime implements Comparable<MeetingTime> {
        int start;
        int end;

        public MeetingTime(int[] arr) {
            start = arr[0];
            end = arr[1];
        }

        @Override
        public int compareTo(MeetingTime o) {
            if (o.end == this.end) {
                return this.start - o.start;

            } else {
                return this.end - o.end;

            }
        }

        @Override
        public String toString() {
            return String.format("start: %d, end: %d", start, end);
        }
    }

    public int solution(int[][] arrays) {
        int answer = 0;
        List<MeetingTime> times = new ArrayList<>();
        for (int[] time: arrays) {
            times.add(new MeetingTime(time));
        }

        Collections.sort(times);
        for (MeetingTime time: times) {
            System.out.println("time = " + time);
        }

        int lastEndTime = 0;
        for (MeetingTime time: times) {
            if (time.start >= lastEndTime) {
                lastEndTime = time.end;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MeetingRoom meetingRoom = new MeetingRoom();
        int[][] case1 = new int[][]{{1,4},{2,3},{3,5},{4,6},{5,7}};
        int[][] case2 = new int[][]{{3,3},{1,3},{2,3}};

        int answer = meetingRoom.solution(case2);
        System.out.println("answer = " + answer);
    }
}
