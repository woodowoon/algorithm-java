package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 카드 합체 놀이 15903
public class CardCombinationGame {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Long> cards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cards.add(Long.parseLong(String.valueOf(scanner.nextInt())));
        }

        scanner.close();

        logic(cards, m);
    }

    private static void logic(List<Long> cards, int m) {
        PriorityQueue<Long> queue = new PriorityQueue<>();

        queue.addAll(cards);

        for (int i = 0; i < m; i++) {
            Long x = queue.poll();
            Long y = queue.poll();

            Long sum = x + y;

            queue.add(sum);
            queue.add(sum);
        }

        long totalSum = 0;

        while (!queue.isEmpty()) {
            totalSum += queue.poll();
        }

        System.out.println(totalSum);

    }


}
