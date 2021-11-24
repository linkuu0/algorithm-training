package programmers.dfs;

public class ConvertWord {
    private int answer;

    public void dfs (int level, String curr, String target, String[] words, boolean[] visited) {
        if (target.equals(curr)) {
            answer = Math.min(answer, level);
            return;
        }

        for (int i=0; i<words.length; i++) {
            if (!visited[i] && isTargetWord(curr, words[i])) {
                visited[i] = true;
                dfs(level + 1, words[i], target, words, visited);
                visited[i] = false;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        answer = words.length + 1;
        boolean[] visited = new boolean[words.length];
        dfs(0, begin, target, words, visited);

        return answer == words.length + 1 ? 0 : answer;
    }

    public boolean isTargetWord(String word, String target) {
        int cnt = 0;
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) != target.charAt(i))
                cnt++;
        }

        return cnt == 1;
    }

    public static void main(String[] args) {
        ConvertWord convertWord = new ConvertWord();
        int answer = convertWord.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        System.out.println("answer = " + answer);

    }
}
