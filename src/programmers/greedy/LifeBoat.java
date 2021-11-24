package programmers.greedy;

import java.util.Arrays;

/** TODO 로직 재검토
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int i=0;
        for (int j=people.length-1; i<=j; j--) {
            if (people[i] + people[j] > limit) {
                answer++;
            } else {
                answer++;
                i++;
            }
        }

        return answer;
    }

}
