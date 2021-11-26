package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [프로그래머스] Lv.2 문자열 압축
 * @link https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class CharCompress {
    public int solution(String s) {
        int answer = s.length();

        // 굳이 없어도 됨
        if (s.length() == 1)
            return 1;

        for (int i=1; i<=s.length()/2; i++) {  // 문자열 묶는 갯수 계산 용도 인덱스
            StringBuilder result = new StringBuilder();
            String pattern = "";
            int cnt = 1;

            for (int j=0; j<(s.length()/i) + 1; j++) {  // 짝수인 경우 처리해야해서.. 루프 한번더돔
                int maxIndex = Math.min((j + 1) * i, s.length());
                String substring = s.substring(j * i, maxIndex);
                if (!pattern.equals(substring)) {
                    if (cnt != 1) {
                        result.append(cnt);
                        cnt = 1;
                    }
                    result.append(pattern);
                    pattern = substring;


                } else {
                    cnt++;

                }

//                System.out.print(substring + " ");
            }

            if (cnt != 1) {
                result.append(cnt);
            }
            result.append(pattern);

//            System.out.println();
            answer = Math.min(answer, result.length());
//            System.out.println("result.toString() = " + result.toString());
//            System.out.println("result.toString().length() = " + result.toString().length());
//            break;
        }

        return answer;
    }

    @Test
    void test1() {
        int answer = solution("aabbaccc");
        Assertions.assertThat(answer).isEqualTo(7);
    }

    @Test
    void test2() {
        int answer = solution("ababcdcdababcdcd");
        Assertions.assertThat(answer).isEqualTo(9);
    }

    @Test
    void test3() {
        int answer = solution("abcabcdede");
        Assertions.assertThat(answer).isEqualTo(8);
    }

    @Test
    void test4() {
        int answer = solution("abcabcabcabcdededededede");
        Assertions.assertThat(answer).isEqualTo(14);
    }

    @Test
    void test5() {
        int answer = solution("xababcdcdababcdcd");
        Assertions.assertThat(answer).isEqualTo(17);
    }
}
