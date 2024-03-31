package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 10773번 제로
public class Zero {

    public static void main(String[] args) {
//        useStackSolve();
        useNotStackSolve();
    }

    // 스택으로 풀이
    public static void useStackSolve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Deque<Integer> moneyQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();

            if (money == 0 && !moneyQueue.isEmpty()) moneyQueue.pollLast();
            else moneyQueue.offer(money);
        }

        int sum = 0;
        while (!moneyQueue.isEmpty()) {
            sum += moneyQueue.poll();
        }

        scanner.close();

        System.out.println(sum);
    }

    // 스택 없이 풀이 List 로
    public static void useNotStackSolve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> moneys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            if (money == 0 && !moneys.isEmpty()) {
                moneys.remove(moneys.size() - 1);
            } else {
                moneys.add(money);
            }
        }

        scanner.close();

        System.out.println(
                moneys.stream().mapToInt(Integer::intValue).sum()
        );
    }


}
