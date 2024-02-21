package algorithm.co.algorithmjava.code.gpt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 슬라이딩 윈도우 기법 학습
public class FindConsecutiveSubarraySum {

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

}
