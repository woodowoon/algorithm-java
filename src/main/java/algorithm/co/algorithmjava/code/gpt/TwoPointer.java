package algorithm.co.algorithmjava.code.gpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TwoPointer {
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        List<String> str = List.of(br.readLine().split(" "));
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(str.get(i)));
        }

        br.close();

        logic(numbers, s);
    }

    private static void logic(List<Integer> numbers, Integer s) {
        int start = 0;
        int currentSum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int end = 0; end < numbers.size(); end++) {
            currentSum += numbers.get(end);

            while (currentSum >= s) {
                minSize = Math.min(minSize, (end - start) + 1);

                currentSum -= numbers.get(start);
                start++;
            }
        }

        if (minSize == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minSize);
        }
    }
}
