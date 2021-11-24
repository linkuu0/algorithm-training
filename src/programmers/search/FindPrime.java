package programmers.search;

import java.util.HashSet;
import java.util.Set;

public class FindPrime {
    Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        generate("", numbers);
//        System.out.println("numberSet = " + numberSet);

        for (Integer number: numberSet) {
            if (isPrime(number))
                answer++;
        }

        return answer;
    }

    public void generate(String curr, String target) {
        if (!"".equals(curr)) {
            numberSet.add(Integer.valueOf(curr));
        }

        for (int i=0; i<target.length(); i++) {
            generate(curr + target.charAt(i), target.substring(0, i) + target.substring(i + 1));
        }
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i=2; i<=sqrt; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();
        int answer = findPrime.solution("15");

        System.out.println("answer = " + answer);
    }
}
