package algorithm.co.algorithmjava.code.book;

import java.util.*;

// N 번째 큰수 2075번
public class FindMaxNValue {
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < Math.pow(n, 2); i++) {
            numbers.add(scanner.nextInt());
        }

        System.out.println("numbers = " + numbers);

        logic(numbers, n);
    }

    private static void logic(List<Integer> numbers, Integer n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(numbers);

        int magicNum = 0;

        for (int i = 0; i < n; i++) {
            magicNum = queue.poll();
        }

        System.out.println("magicNum = " + magicNum);
    }
}
