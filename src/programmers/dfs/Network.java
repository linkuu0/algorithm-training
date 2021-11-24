package programmers.dfs;

// TODO DFS 로직 개선 가능성 고려
public class Network {

    public boolean[] dfs(int level, int[][] computers, boolean[] check) {
        check[level] = true;

        for (int i=0; i<computers.length; i++) {
            if (level != i  // 현재 항목 조회 하지 않음
                && computers[level][i] == 1
                && !check[i]) {

                check = dfs(i, computers, check);
            }
        }

        return check;
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!check[i]) {
                dfs(i, computers, check);
                answer++;
            }
        }

        return answer;
    }
}
