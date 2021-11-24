package programmers.greedy;

public class MakeBigNumber {

    public String solution(String number, int k) {
        int n = number.length() - k;
        int left = 0, right = k;
        int maxIndex = 0;
        int maxValue;

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            maxValue = 0;  // 초기화

            for (int i=left; i<=right; i++) {
                int num = number.charAt(i) - '0';
                if (num > maxValue) {
                    maxIndex = i;
                    maxValue = num;
                }
            }

//            System.out.println("number.charAt(index) = " + number.charAt(maxIndex));
            sb.append(maxValue);
            left = maxIndex + 1;
            right = number.length() - --n;

        }

        return sb.toString();
    }
}
