package algorithm.co.algorithmjava.code.gpt;

import java.util.*;

public class MagicNumber {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배수가 될 숫자 개수를 입력해주세요. : ");
        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        System.out.println("공백으로 구분된 숫자를 입력해주세요.");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        System.out.print("몇번째로 작은 마법의 숫자를 구하시겠습니까? : ");
        int resultNum = scanner.nextInt();

        scanner.close();

        findMaxKValue2(numbers, resultNum);
    }

    private static void findMagicNumber(List<Integer> numbers, Integer resultNum) {
        System.out.println("numbers = " + numbers);
        System.out.println("resultNum = " + resultNum);
        Set<Integer> resultNumbers = new HashSet<>();

        for (Integer number : numbers) {
            for (int j = 1; j < resultNum; j++) {
                resultNumbers.add(number * j);
            }
        }

        List<Integer> resultNumberList = new ArrayList<>(resultNumbers);
        Collections.sort(resultNumberList);

        System.out.println("resultNumberList = " + resultNumberList);

        System.out.println(resultNumberList.get(resultNum - 1));
    }

    // 우선 순위 큐
    private static void findMagicNumberQueue(List<Integer> numbers, Integer resultNum) {
        // 우선순위 큐와 집합을 초기화합니다.
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        queue.add(1L);
        seen.add(1L);

        // 초기 숫자들을 큐와 집합에 추가합니다.
        for (int num : numbers) {
            queue.add((long) num);
            seen.add((long) num);
        }

        long magicNumber = 0;

        for (int i = 0; i < resultNum; i++) {
            // 우선순위 큐에서 가장 작은 숫자를 꺼냅니다.
            System.out.println("1111111111");
            // 첫번째 값 반환
            magicNumber = queue.poll();
            System.out.println("magicNumber = " + magicNumber);

            // 꺼낸 숫자에 대해 입력된 모든 숫자를 곱하여 다시 큐에 추가합니다.
            for (int num : numbers) {
                System.out.println("22222222222222");

                long newNumber = magicNumber * num;
                System.out.println("newNumber = " + newNumber);
                // 중복된 숫자는 추가하지 않습니다.
                if (seen.add(newNumber)) {
                    queue.add(newNumber);
                }
            }
        }

        System.out.println(resultNum + "번째 마법의 숫자는: " + magicNumber);
    }

    private static void findMinKValue(List<Integer> numbers, Integer K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.addAll(numbers);

        int magicNumber = 0;

        for (int i = 0; i < K; i++) {
            magicNumber = queue.poll();
        }

        System.out.println("magicNumber = " + magicNumber);
    }

    private static void findMaxKValue(List<Integer> numbers, Integer K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.addAll(numbers);

        int magicNum = 0;
        for (int i = 0; i < numbers.size() - K + 1; i++) {
            magicNum = queue.poll();
        }

        System.out.println("magicNum = " + magicNum);
    }

    private static void findMaxKValue2(List<Integer> numbers, Integer K) {
        // 최대 힙을 구현하기 위한 우선순위 큐 초기화
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 숫자들을 큐에 추가
        queue.addAll(numbers);

        System.out.println("queue = " + queue);

        int magicNum = 0;
        // K번째까지의 요소를 제거
        for (int i = 0; i < K; i++) {
            magicNum = queue.poll();
            System.out.println("magicNum = " + magicNum);
        }

        System.out.println("K번째로 큰 값 = " + magicNum);
    }

}
