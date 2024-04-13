package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 19638번 센티와 마법의 뿅망치
public class SentiMagicHammer {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int giantNumber = scanner.nextInt();
        int senti = scanner.nextInt();
        int hammerCount = scanner.nextInt();

        PriorityQueue<Integer> giants = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < giantNumber; i++) {
            int giant = scanner.nextInt();
            giants.offer(giant);
        }

        scanner.close();

        logic(giants, senti, hammerCount);
    }

    private static void logic(PriorityQueue<Integer> giants, int senti, int hammerCount) {
        int useHammerCount = 0;

        while (hammerCount != 0) {
            if (giants.peek() < senti || giants.peek() == 1) {
                break;
            }

            hammerCount--;
            useHammerCount++;
            giants.add(giants.poll() / 2);
        }

        String answer = "";

        if (giants.peek() < senti) answer = "YES";
        else answer = "NO";

        System.out.println(answer + "\n" + (answer.equals("YES") ? useHammerCount : giants.poll()));
    }
}
