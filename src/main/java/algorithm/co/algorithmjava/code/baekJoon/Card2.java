package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 2164번 카드2
public class Card2 {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }

        scanner.close();

        System.out.println(logic(queue));
    }

    private static int logic(Deque<Integer> cards) {
        Deque<Integer> queue = new LinkedList<>();

        for (Integer card : cards) {
            queue.offer(card);
        }

        while (queue.size() > 1) {
            // 맨위의 숫자를 버리고
            queue.poll();

            // 그위의 숫자를 빼서 가장 마지막에 넣는다.
            queue.offerLast(queue.poll());
        }

        return queue.isEmpty() ? -1 : queue.peek();
    }

}
