package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1697번 숨바꼭질
public class HideAndSeek {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        scanner.close();

        System.out.println(findMinTime(n, k));
    }

    private static int findMinTime(int N, int K) {
        int[] visited = new int[100001];
        Arrays.fill(visited, -1); // 방문하지 않은 위치는 -1로 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 0; // 시작 위치는 0초로 설정

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 목표 위치에 도달했다면, 해당 위치까지 걸린 시간 반환
            if (current == K) {
                return visited[current];
            }

            // 현재 위치에서 이동할 수 있는 세 가지 경우 확인
            int[] nextPositions = {current - 1, current + 1, current * 2};
            for (int next : nextPositions) {
                // 다음 위치가 유효한 범위 내이고 아직 방문하지 않았다면
                if (next >= 0 && next <= 100000 && visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1; // 이론적으로 도달할 수 없는 경우
    }
}

