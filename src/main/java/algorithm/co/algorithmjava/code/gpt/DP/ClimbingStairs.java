package algorithm.co.algorithmjava.code.gpt.DP;

import java.util.Scanner;

// 동적계획법 계단오르기
public class ClimbingStairs {

    public static void main(String[] args){
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.close();

        int logic = logic(n);
        System.out.println("logic = " + logic);
    }

    private static int logic(int n) {
        if (n == 1) return 1; // n이 1일 경우를 처리

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }


        return dp[n];
    }

}
