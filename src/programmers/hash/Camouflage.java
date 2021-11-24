package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] c: clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        return map.values().stream()
                .mapToInt(value -> value + 1)
                .reduce(1, (a, b) -> a * b) - 1;
    }

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();
        String[][] clothes = new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        int answer = camouflage.solution(clothes);
        System.out.println("answer = " + answer);
    }
}
