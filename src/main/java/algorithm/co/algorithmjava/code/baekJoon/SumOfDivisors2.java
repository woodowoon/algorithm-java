package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 17427번 약수의합2
public class SumOfDivisors2 {

    public static void main(String[] args) {
        gptLogic();
    }

    public static void gptLogic() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            // i가 약수인 숫자들의 합
            System.out.println("i = " + i);
            System.out.println(" (n / i) * i = " + (n / i) * i);
            sum += (long) (n / i) * i;
        }

        System.out.println(sum);
        scanner.close();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int n = scanner.nextInt();

        for (int i = 1; i < n + 1; i++) {
            sum += logic(i);
        }

        scanner.close();

        System.out.println(sum);
    }

    private static int logic(Integer number) {
        int sum = 1;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 2;
        while (number != 1) {
            if (number % i == 0) {
                number = number / i;
                map.put(i, map.getOrDefault(i, 0) + 1);

                i = 2;
            } else {
                i++;
            }
        }

        if (map.isEmpty()) {
            return 1;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            int plus = 1;

            for (int j = 1; j < value + 1; j++) {
                plus = (int) (plus + Math.pow(key, j));
            }

            sum *= plus;
        }

        return sum;
    }

}
