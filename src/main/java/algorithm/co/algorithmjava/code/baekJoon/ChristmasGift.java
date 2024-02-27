package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 크리스마스 선물 14235
public class ChristmasGift {
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // 줄 수를 입력받습니다.
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> numbers = new ArrayList<>();
            String line = scanner.nextLine(); // 한 줄을 전체로 읽습니다.
            for (String token : line.split(" ")) { // 공백으로 분리
                numbers.add(Integer.parseInt(token));
            }

            lists.add(numbers);
        }

        logic(lists);

        scanner.close();
    }

    private static void logic(List<List<Integer>> lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (List<Integer> list : lists) {
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    if (list.get(0) == 0) {
                        if (queue.isEmpty()) {
                            System.out.println("-1");
                        } else {
                            System.out.println(queue.poll());
                        }
                    }
                } else {
                    queue.add(list.get(j));
                }
            }
        }
    }
}
