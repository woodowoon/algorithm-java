package algorithm.co.algorithmjava.code.gpt.DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinCoinExchange {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        // 사용자로부터 동전 종류를 입력받음
        String[] coinStrings = scanner.nextLine().split(", ");

        // 문자열 배열을 정수 배열로 변환
        int[] coins = new int[coinStrings.length];
        for (int i = 0; i < coinStrings.length; i++) {
            coins[i] = Integer.parseInt(coinStrings[i]);
        }
        int amount = scanner.nextInt();

        scanner.close();

        int logic = logic(coins, amount);

        System.out.println("logic = " + logic);
    }

    private static int logic(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 매우 큰 값으로 초기화
        dp[0] = 0; // 0원을 만드는 데 필요한 동전 수는 0개

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount]; // 계산된 값이 초기값보다 크면 -1 반환
    }

}
