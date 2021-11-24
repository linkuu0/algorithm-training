package programmers.greedy;

import java.util.Arrays;

public class SportsWear {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];

        for (int l: lost) students[l-1]--;
        for (int r: reserve) students[r-1]++;

        for (int i=0; i<n; i++) {
            if (students[i] < 0) {
                if (i != 0 && students[i-1] > 0) {
                    students[i]++;
                    students[i-1]--;

                } else if (i != n-1 && students[i+1] > 0) {
                    students[i]++;
                    students[i+1]--;

                }
            }
        }

        return Arrays.stream(students)
                .map(s -> (s >= 0) ? 1 : 0)
                .sum();
    }
}
