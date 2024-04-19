package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Scanner;

// 2579번 계단 오르기
public class ClimbingStairs {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 계단의 개수
        int[] scores = new int[n + 1]; // 계단 점수 배열
        for (int i = 1; i <= n; i++) {
            scores[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println(scores[1]);
            return;
        }

        int[] dp = new int[n + 1]; // 최대 점수 저장 배열
        dp[1] = scores[1];
        if (n > 1) {
            dp[2] = scores[1] + scores[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + scores[i], dp[i-3] + scores[i-1] + scores[i]);
        }

        System.out.println(dp[n]);
    }

}
