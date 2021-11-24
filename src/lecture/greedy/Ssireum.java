package lecture.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ssireum {

    static class Player implements Comparable<Player> {
        int height;
        int weight;

        public Player(int[] arr) {
            this.height = arr[0];
            this.weight = arr[1];
        }

        @Override
        public int compareTo(Player p) {
            return p.height - this.height;
        }
    }

    public int solution(int[][] arr) {
        List<Player> players = new ArrayList<>();
        for (int[] p : arr) {
            players.add(new Player(p));
        }
        Collections.sort(players);

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (Player p: players) {
            if (p.weight > max) {
                max = p.weight;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ssireum ssireum = new Ssireum();
        int[][] players = new int[][] {{172,67}, {183,65}, {180,70}, {170,72}, {181,60}};
        int answer = ssireum.solution(players);

        System.out.println("answer = " + answer);
    }
}
