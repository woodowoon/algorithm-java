package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 29700번 우당탕탕 영화예매
public class MovieReservation {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int people = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            List<Integer> cinema = new ArrayList<>();
            String s = scanner.next();

            for (char c : s.toCharArray()) {
                cinema.add(Character.getNumericValue(c));
            }

            count += logic(people, cinema);
        }

        scanner.close();

        System.out.println(count);
    }

    private static int logic(int people, List<Integer> cinema) {
        int start = 0;
        int count = 0;
        int peopleCount = 0;
        for (int end = 0; end < cinema.size(); end++) {
            if (cinema.get(end) == 1) {
                peopleCount++;
            }

            while (end - start + 1 >= people) {
                if (peopleCount == 0) {
                    count++;
                }

                if (cinema.get(start) == 1) {
                    peopleCount--;
                }
                start++;
            }
        }

        return count;
    }

}
