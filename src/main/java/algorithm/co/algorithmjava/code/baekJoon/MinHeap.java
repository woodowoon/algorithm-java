package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 1927번 최소힙
public class MinHeap {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        logic(numbers);
    }

    private static void logic(List<Integer> numbers) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Integer number : numbers) {
            if (number == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(number);
            }
        }
    }

    // 입력받는 동시에 처리하는 내용
    public static void newLogic() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 연산의 개수 N
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 최소 힙 구현

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            if (number == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0); // 배열이 비어있으면 0 출력
                } else {
                    System.out.println(queue.poll()); // 가장 작은 값 출력 및 제거
                }
            } else {
                queue.add(number); // 배열에 자연수 x 추가
            }
        }

        scanner.close();
    }
}
