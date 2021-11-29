package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsClustering {

    public List<String> getMultiSet(String str) {
        List<String> multiSet = new ArrayList<>();

        for (int i=0; i<str.length() - 1; i++) {
            if (!(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i+1)))) {
                continue;
            }

            multiSet.add(str.charAt(i)+""+str.charAt(i+1));
        }

        return multiSet;
    }

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> union = new ArrayList<>();
        List<String> intersect = new ArrayList<>();

        List<String> multiset1 = getMultiSet(str1);
        List<String> multiset2 = getMultiSet(str2);

        Collections.sort(multiset1);
        Collections.sort(multiset2);

        for (String element: multiset1) {
            if (multiset2.remove(element)) {
                intersect.add(element);
            }

            union.add(element);
        }

        union.addAll(multiset2);

        double answer = 0;

        if (union.size() == 0) {
            answer = 1;
        } else {
            answer = (double) intersect.size() / union.size();
        }

        return (int) (answer * 65536);
    }

    @Test
    void test() {
        int answer = solution("FRANCE", "french");
        Assertions.assertThat(answer).isEqualTo(16384);

        int answer2 = solution("handshake", "shake hands");
        Assertions.assertThat(answer2).isEqualTo(65536);

        int answer3 = solution("aa1+aa2", "AAAA12");
        Assertions.assertThat(answer3).isEqualTo(43690);

        int answer4 = solution("E=M*C^2", "e=m*c^2");
        Assertions.assertThat(answer4).isEqualTo(65536);

    }
}
