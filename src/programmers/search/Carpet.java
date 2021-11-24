package programmers.search;

import java.util.Arrays;

/**
 * 가로 >= 세로
 * TODO
 */
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int width = 0, height;
        for (height = 3; height <= (int) (brown + 4) / 2; height++) {
            width = ((brown + 4) / 2) - height;

            if (width < height || yellow == (width - 2) * (height - 2))
                break;
        }

        return new int[] {width, height};
    }
}
