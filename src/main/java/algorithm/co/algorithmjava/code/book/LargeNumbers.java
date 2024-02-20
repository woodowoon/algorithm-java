package algorithm.co.algorithmjava.code.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 큰수의 법칙
public class LargeNumbers {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            data.add(scanner.nextInt());
        }

        scanner.close();

        int numbers = numbers(data, M, K);
    }

    private static int numbers(List<Integer> numbers, int M, int K) {
        // 1. M 과 K 를 비교해서 얼마나 차이가 나는지 비교한다.
        int size;
        int remain;
        if (M > K) {
            size = M / K;
            remain = M % K;
        } else if (M < K){
            size = M;
            remain = 0;
        } else {
            size = M;
            remain = 0;
        }

        System.out.println("size = " + size);
        System.out.println("remain = " + remain);

        // 2. numbers 를 sort 해서 가장 큰 수와 그 다음 큰수를 구한다.
        numbers.sort(Collections.reverseOrder());

        Integer a = numbers.get(0);
        Integer b = numbers.get(1);

        // 3. 더한다.
        return ((a * K)) * size + (b * remain);
    }

}
