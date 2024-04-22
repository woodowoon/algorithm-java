package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 2839번 설탕배달
public class SugarDelivery {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int sugar = scanner.nextInt();
        List<Integer> boxs = new ArrayList<>(Arrays.asList(3, 5));

        scanner.close();

        int logic = logic(sugar, boxs);
        System.out.println(logic);
    }

    public static int logic(int sugar, List<Integer> boxs) {
        if (sugar < 3 || sugar == 4) return -1;
        int[] dp = new int[sugar + 5];
        Arrays.fill(dp, sugar + 5);
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= sugar; i++) {
            for (Integer box : boxs) {
                dp[i] = Math.min(dp[i], dp[i-box] + 1);
            }
        }

        return dp[sugar] == sugar + 5 ? -1 : dp[sugar];
    }

}
