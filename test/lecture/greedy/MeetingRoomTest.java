package lecture.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MeetingRoomTest {

    @Test
    void test() {
        MeetingRoom meetingRoom = new MeetingRoom();
        int[][] case1 = new int[][]{{1,4},{2,3},{3,5},{4,6},{5,7}};
        int[][] case2 = new int[][]{{3,3},{1,3},{2,3}};

        int answer1 = meetingRoom.solution(case1);
        Assertions.assertThat(answer1).isEqualTo(3);

        int answer2 = meetingRoom.solution(case2);
        Assertions.assertThat(answer2).isEqualTo(2);
    }
}