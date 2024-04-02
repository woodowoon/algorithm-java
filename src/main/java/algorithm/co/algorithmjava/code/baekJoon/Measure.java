package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 1037번 약수
public class Measure {

    public static void main(String[] args) {
        newInput();
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }

        scanner.close();

        System.out.println(logic(queue));
    }

    private static int logic(PriorityQueue<Integer> queue) {
        int firstNum = queue.poll();
        int lastNum = 0;

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                lastNum = queue.poll();
            } else {
                queue.poll();
            }
        }

        return firstNum * lastNum;
    }

    private static void newInput() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        System.out.println(newLogic2(numbers));
    }

    private static int newLogic(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        int i = 2;
        for (Integer number : numbers) {
            Map<Integer, Integer> map1 = new HashMap<>();

            while (number != 1) {
                if (number % i == 0) {
                    number = number / i;
                    map1.put(i, map1.getOrDefault(i, 0) + 1);
                    map.put(i, Math.max(map1.getOrDefault(i, 0), map.getOrDefault(i, 0)));

                    i = 2;
                } else {
                    i++;
                }
            }
        }

        int result = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result *= Math.pow(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private static int newLogic2(List<Integer> numbers) {
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        return min * max;
    }

}
