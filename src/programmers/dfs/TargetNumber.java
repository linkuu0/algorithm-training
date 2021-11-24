package programmers.dfs;

public class TargetNumber {

    public int dfs(int level, int sum, int[] numbers, int target) {
        if (level == numbers.length) {
            if (sum == target) return 1;
            else return 0;

        } else {
            return dfs(level + 1, sum - numbers[level], numbers, target)
                    + dfs(level + 1, sum + numbers[level], numbers, target);

        }
    }

    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }

    public static void main(String[] args) {
        TargetNumber test = new TargetNumber();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 5;

        int answer = test.solution(numbers, target);
        System.out.println("answer = " + answer);


    }
}
