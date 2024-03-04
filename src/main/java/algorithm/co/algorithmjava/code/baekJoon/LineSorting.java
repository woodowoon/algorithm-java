package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 2631번 줄세우기
public class LineSorting {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }


        scanner.close();

        logic(numbers);
    }

    private static void logic(List<Integer> numbers) {
        List<Integer> newList = new ArrayList<>();

        for (Integer number : numbers) {
            if (newList.isEmpty() || number > newList.get(newList.size() - 1)) {
                newList.add(number);
            } else {
                int i = 0;
                int j = newList.size();

                while (i < j) {
                    int mid = (i + j) / 2;

                    if (number > newList.get(mid)) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                newList.set(i, number);
            }
        }

        System.out.println(numbers.size() - newList.size());
    }

}
