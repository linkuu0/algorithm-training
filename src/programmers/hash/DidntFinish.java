package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class DidntFinish {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p: participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c: completion) {
            map.put(c, map.get(c) - 1);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0)
                return entry.getKey();
        }

        return "";
    }


    public static void main(String[] args) {
        DidntFinish didntFinish = new DidntFinish();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};

        String answer = didntFinish.solution(participant, completion);
        System.out.println("answer = " + answer);
    }
}
