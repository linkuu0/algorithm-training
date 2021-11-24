package programmers.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravelPath {

    private List<String> answer = new ArrayList<>();
    private boolean[] visited;

    public void dfs(int level, String curr, String path, String[][] tickets) {
        if (level == tickets.length) {
            answer.add(path);

        } else {
            for (int i=0; i<tickets.length; i++) {
                if (!visited[i] && curr.equals(tickets[i][0])) {
                    curr = tickets[i][1];
                    path = path + " " + curr;

                    visited[i] = true;
                    dfs(level + 1, curr, path, tickets);
                    visited[i] = false;
                }
            }

        }
    }

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
}
