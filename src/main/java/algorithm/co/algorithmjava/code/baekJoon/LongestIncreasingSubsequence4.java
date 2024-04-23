package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 14002번 가장 긴 증가하는 부분 수열4
public class LongestIncreasingSubsequence4 {
    static class Number {
        int size;
        List<Integer> numbers;

        public Number(int size, List<Integer> numbers) {
            this.size = size;
            this.numbers = numbers;
        }
    }

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            numbers.add(number);

        }
        scanner.close();

        Number logic = logic(numbers);
        StringBuilder sb = new StringBuilder();

        sb.append(logic.size).append("\n");
        for (Integer number : logic.numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }

    private static Number logic(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();

        for (Integer number : numbers) {
            if (list.isEmpty() || list.get(list.size() - 1) < number) {
                list.add(number);
            } else {
                int i = 0;
                int j = list.size() - 1;
                while (i < j) {
                    int mid = (i + j) / 2 ;

                    if (list.get(mid) < number) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                list.set(i, number);
            }
        }

        return new Number(list.size(), list);
    }

}
