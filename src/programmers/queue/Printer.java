package programmers.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int p: priorities) {
            queue.add(p);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;

            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        return count;
                    }
                    queue.poll();
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int answer = printer.solution(new int[]{2,1,3,2}, 2);

        System.out.println("answer = " + answer);


    }
}
