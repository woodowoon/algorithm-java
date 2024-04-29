package algorithm.co.algorithmjava.code.book.codingTest.greedy;

import java.util.*;

// 숫자 카드 게임
public class NumberCardGame {

    public static void main(String[] args) {
        mySolution();
    }

    public static void mySolution() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        scanner.nextLine();

        int maxNumber = 0;
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();

            int minNumber = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt)
                    .min()
                    .orElse(Integer.MAX_VALUE);

            maxNumber = Math.max(maxNumber, minNumber);
        }

        scanner.close();

        System.out.println(maxNumber);
    }

}
