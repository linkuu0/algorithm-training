package programmers.greedy;

public class Joystick {
    public int solution(String name) {
        int answer = 0;

        // 좌->우로 마지막까지 이동하는 케이스를 최소값으로 지정
        int min = name.length() - 1;

        // 상하 좌우를 나눠서 연산
        for (int i=0; i<name.length(); i++) {
            // 상하 이동 계산 (문자 선택)
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            int next = i+1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // (커서 이동 누적) 마지막까지 이동하는 케이스와 비교해서 좌우 이동 거리 계산
            min = Math.min(min, i + name.length() - next + i); // 이거 좀 생각을..
        }

        // 커서 이동 추가
        answer += min;

        return answer;
    }
}
