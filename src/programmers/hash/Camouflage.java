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
}
