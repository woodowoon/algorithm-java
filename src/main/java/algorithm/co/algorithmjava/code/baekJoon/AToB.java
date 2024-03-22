package algorithm.co.algorithmjava.code.baekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 16953번 A -> B
public class AToB {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        scanner.close();

        System.out.println(logic(A, B));
    }

    // A -> B 로 가서 메모리 초과 로직 ㅠㅠ..
    private static int logic1(int A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[B+1];

        queue.add(A);
        visited[A] = 1; // 처음 숫자 방문 처리

        while (!queue.isEmpty()) {
            Integer number = queue.poll();

            // 다음 이동 가능한 숫자 리스트
            int[] nextSteps = {Integer.parseInt(number + "1"), number * 2};

            for (int nextStep : nextSteps) {
                if (nextStep <= B && visited[nextStep] == 0) {
                    queue.offer(nextStep);
                    visited[nextStep] = visited[number] + 1;
                }
            }
        }

        return visited[B] == 0 ? -1 : visited[B];
    }

    // B -> A 로 가는 코드로 메모리가 적게들어서 통과!!
    private static int logic(int A, int B) {
        int count = 0;

        while (B > A) {
            // 움직일 수 있는 범위는 (숫자 + 1), (숫자 * 2)
            if (B % 10 == 1) {
                B = B / 10;
            } else if (B % 2 == 0) { // 나누어 떨어지니깐
                B = B / 2;
            } else {
                return -1;
            }

            count++;
        }

        return A == B ? count + 1 : -1;
    }

}
