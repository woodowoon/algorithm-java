package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 최대힙 11279
public class MaxHeap {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            if (number == 0) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                queue.add(number);
            }

        }

        scanner.close();

        System.out.println(sb);
    }

}
