package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 10845번 큐
// 좀 더 확장성 있는 Deque 를 사용하였다.
public class QueueProblem {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        scanner.nextLine();

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] commands = input.split(" ");
            String command = commands[0];

            // 백준에서는 해당 기능을 제공하지 않는다.
            switch (command) {
                case "push" -> {
                    int number = Integer.parseInt(commands[1]);
                    queue.offer(number);
                }
                case "pop" -> sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                case "size" -> sb.append(queue.size()).append("\n");
                case "empty" -> sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                case "front" -> sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                case "back" -> sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
            }
        }

        scanner.close();

        System.out.println(sb);
    }
}
