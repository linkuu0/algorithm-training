package programmers.queue;

import java.util.LinkedList;
import java.util.Queue;

// TODO 다시 한번 확인
public class TrunkOnBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        int time = 0, weightsBridge = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truck);
                    weightsBridge += truck;
                    time++;
                    break;

                } else if (queue.size() == bridge_length) {
                    weightsBridge -= queue.poll();

                } else {
                    // 무게 0 짜리 트럭이 지나가는 것,
                    // 어쟀거나 트럭은 지나가야하기 때문에..
                    if (weightsBridge + truck > weight) {
                        queue.offer(0);
                        time++;

                    } else {
                        // 무게 여유 될 때,
                        queue.offer(truck);
                        weightsBridge += truck;
                        time++;
                        break;
                    }

                }
            }
        }

        return time + bridge_length;
    }

    public static void main(String[] args) {
        TrunkOnBridge trunkOnBridge = new TrunkOnBridge();
        int answer = trunkOnBridge.solution(2, 10, new int[]{7, 4, 5, 6});

        System.out.println("answer = " + answer);
    }
}
