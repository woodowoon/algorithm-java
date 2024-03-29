package algorithm.co.algorithmjava.code.gpt;

import java.util.*;

// 슬라이딩 윈도우 기법 학습
public class SlidingWindow {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열을 몇개 입력하시겠습니까? : ");
        int N = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        System.out.println("띄어쓰기 하여 배열을 입력해주세요. : ");

        for (int i = 0; i < N; i++) {
            numbers.add(scanner.nextInt());
        }

        System.out.print("원하는 합은 어떻게 되나요? : ");
        Integer sum = scanner.nextInt();

        scanner.close();

        findMaxAverageSubarray(numbers, sum);
    }

    private static void subarraySum(List<Integer> numbers, Integer sum) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int testSum = 0;
            for (int j = i; j < numbers.size(); j++) {
                testSum += numbers.get(j);

                if (testSum > sum) {
                    break;
                } else if (testSum == sum) {
                    count += 1;
                    break;
                }
            }
        }

        System.out.println("count = " + count);
    }

    // 슬라이딩 윈도우 기법
    private static void subarraySumSlidingWindow(List<Integer> numbers, Integer sum) {
        int count = 0; // 조건을 만족하는 부분 배열의 개수
        int currentSum = 0; // 현재 윈도우의 합
        int start = 0; // 윈도우의 시작 인덱스

        for (Integer number : numbers) {
            // 현재 원소를 현재 윈도우의 합에 더함
            System.out.println("number = " + number);

            currentSum += number;

            // 현재 윈도우의 합이 sum보다 크거나 같을 때까지 윈도우의 시작점을 오른쪽으로 이동
            while (currentSum >= sum) {
                System.out.println("currentSum 예에 = " + currentSum);
                System.out.println("sum = " + sum);
                if (currentSum == sum) {
                    count++; // 현재 윈도우의 합이 sum과 같으면 카운트 증가
                }

                System.out.println("number = " + number);
                System.out.println("numbers = " + numbers.get(start));
                System.out.println("currentSum1 = " + currentSum);
                // 윈도우의 시작점을 오른쪽으로 이동시키며 현재 윈도우의 합에서 값을 뺌
                currentSum -= numbers.get(start);
                System.out.println("currentSum = " + currentSum);
                start++;
            }
        }

        System.out.println("count = " + count);
    }

    private static void findMaxLengthSubarray(List<Integer> numbers, Integer sum) {
        List<Integer> sizeArray = new ArrayList<>();
        int start = 0;
        int currentSum = 0;

        for(Integer number : numbers) {
            currentSum += number;

            while (currentSum > sum) {
                currentSum -= numbers.get(start);
                start++;
            }

            // 이 방법은 만약 number 이 값은값이 어려개 있을 경우 문제가 발생할 수 있다.
            sizeArray.add(numbers.indexOf(number) - start + 1);
        }

        sizeArray.sort(Collections.reverseOrder());

        System.out.println("sizeArray.get(0) = " + sizeArray.get(0));
    }

    private static void findMaxLengthSubarray2(List<Integer> numbers, Integer sum) {
        int maxLength = 0; // 최대 길이를 저장
        int start = 0; // 윈도우의 시작점
        int currentSum = 0; // 현재 윈도우의 합

        for (int end = 0; end < numbers.size(); end++) {
            currentSum += numbers.get(end); // 윈도우의 끝을 확장하며 합을 더함

            // 합이 sum을 초과하는 동안 시작점을 오른쪽으로 이동
            while (currentSum > sum) {
                currentSum -= numbers.get(start);
                start++;
            }

            // 최대 길이 업데이트
            maxLength = Math.max(maxLength, end - start + 1);
        }

        System.out.println("Maximum length: " + maxLength);
    }

    private static void findMinLengthSubarray(List<Integer> nums, Integer sum) {
        int start = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < nums.size(); end++) {
            currentSum += nums.get(end);

            while (currentSum >= sum) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= nums.get(start);
                start++;
            }

        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println("minLength = 0"); // 합이 sum 이상인 부분 배열을 찾을 수 없는 경우
        } else {
            System.out.println("minLength = " + minLength); // 찾을 수 있는 경우, 최소 길이 출력
        }
    }

    private static void findMaxAverageSubarray(List<Integer> nums, Integer minSize) {
        int start = 0;
        int currentSum = 0;
        double maxAverage = 0.0;

        for (int end = 0; end < nums.size(); end++) {
            currentSum += nums.get(end);

            while (end - start + 1 >= minSize) {
                maxAverage = Math.max(maxAverage, currentSum / (double) (end - start + 1));
                currentSum -= nums.get(start);
                start++;
            }
        }

        System.out.println("maxAverage = " + maxAverage);
    }

    public static void inputFruit() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("과일의 종류 개수를 입력해주세요 : ");
        int n = scanner.nextInt(); // 과일 종류의 개수

        System.out.print("과일의 판매 기간을 알려주세요 : ");
        int day = scanner.nextInt();

        Map<String, List<Integer>> fruits = new HashMap<>();

        scanner.nextLine(); // 숫자 입력 후 남은 개행 문자 제거

        for (int i = 0; i < n; i++) {
            System.out.print("과일 이름을 입력해주세요 : ");
            String name = scanner.nextLine(); // 과일 이름 입력

            List<Integer> numbers = new ArrayList<>();
            System.out.println(name + "의 판매 기록을 입력해주세요 (띄어쓰기로 구분) : ");
            for (int j = 0; j < day; j++) {
                numbers.add(scanner.nextInt()); // 판매 기록 입력
            }

            fruits.put(name, numbers); // 과일과 판매 기록을 맵에 저장

            if (i < n - 1) {
                scanner.nextLine(); // 숫자 입력 후 남은 개행 문자 제거 (다음 과일 이름 입력을 위해)
            }
        }

        System.out.println("알고싶은 연속된 기간을 알려주세요. : ");
        int newDay = scanner.nextInt();

        findMaxSalesFruitOverPeriod(newDay, fruits);

        scanner.close();

    }

    // 해당 방법은 최대 판매량이 같은 과일이 여러개일 경우를 처리하지 않았다.
    private static void findMaxSalesFruitOverPeriod(Integer day, Map<String, List<Integer>> fruits) {
        int resultSalesCount = 0;
        int resultSaleDay = 0;
        String resultFruitName = "디폴트";

        for(String key : fruits.keySet()) {
            int start = 0;
            int currentSum = 0;

            for (int end = 0; end < fruits.get(key).size(); end++) {
                currentSum += fruits.get(key).get(end);

                while (end - start + 1 == day) {
                    if (resultSalesCount <= currentSum) {
                        if (resultSalesCount == currentSum & resultFruitName.equals(key)) {
                            resultSaleDay += 1;
                        } else {
                            resultFruitName = key;
                            resultSalesCount = currentSum;
                            resultSaleDay = 1;
                        }
                    }
                    currentSum -= fruits.get(key).get(start);
                    start++;
                }
            }
        }

        System.out.println("최대 판매량 : " + resultSalesCount);
        System.out.println("최대 판매량 개수 : " + resultSaleDay);
        System.out.println("최대 판매량 과일 : " + resultFruitName);

    }

    // 최대 판매량이 같은 과일이 여러개일 경우는
    // 1. 최대 판매량을 달성한 일수를 봐서 일수가 가장 많은 과일이 1등이다.
    // 2. 만약 일수조차 똑같다면 함께 출력한다.
    private static void findMaxSalesFruitOverPeriod2() {

    }

}
