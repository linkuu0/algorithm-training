package programmers.array;

public class Keypad {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int left = 10;
        int right = 12;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left = number;

            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right = number;

            } else {
                number = (number == 0) ? 11 : number;
                
                // TODO 수정
                int leftDist = (Math.abs(number - left)) / 3 + (Math.abs(number - left)) % 3;
                int rightDist = (Math.abs(right - number)) / 3 + (Math.abs(right - number)) % 3;

                if (leftDist < rightDist) {
                    sb.append("L");
                    left = number;

                } else if (leftDist > rightDist) {
                    sb.append("R");
                    right = number;

                } else {
                    switch (hand) {
                        case "left":
                            sb.append("L");
                            left = number;
                            break;

                        case "right":
                            sb.append("R");
                            right = number;
                            break;
                    }

                }

            }
        }

        return sb.toString();
    }
}
