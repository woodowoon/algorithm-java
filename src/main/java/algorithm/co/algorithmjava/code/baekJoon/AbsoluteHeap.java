package algorithm.co.algorithmjava.code.baekJoon;

import java.util.PriorityQueue;
import java.util.Scanner;

// 11286번 절댓값 힙
public class AbsoluteHeap {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    int abs1 = Math.abs(o1);
                    int abs2 = Math.abs(o2);

                    if (abs1 == abs2) return o1 > o2 ? 1 : -1;
                    return abs1 - abs2;
                });

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if (number == 0) {
                if (!queue.isEmpty()) {
                    stringBuilder.append(queue.poll()).append("\n");
                } else {
                    stringBuilder.append(0).append("\n");
                }
            } else {
                queue.add(number);
            }
        }

        scanner.close();

        System.out.println(stringBuilder);
    }

    private static void logic() {

    }
}
