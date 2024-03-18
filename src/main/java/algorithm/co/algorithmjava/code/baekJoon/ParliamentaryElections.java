package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 1417번 국회의원 선거
public class ParliamentaryElections {

    // 다솜은 기호 1번
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int dasom = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dasom = scanner.nextInt();
            } else {
                int value = scanner.nextInt();
                queue.offer(value);
            }
        }

        scanner.close();

        logic(dasom, queue);
    }

    private static void logic(Integer dasom, PriorityQueue<Integer> queue) {
        int count = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if (poll >= dasom) {
                poll--;
                dasom++;
                count++;

                queue.offer(poll);
            }
        }

        System.out.println(count);
    }

}
