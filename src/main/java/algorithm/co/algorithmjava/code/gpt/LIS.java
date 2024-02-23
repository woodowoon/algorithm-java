package algorithm.co.algorithmjava.code.gpt;

import java.util.*;

public class LIS {
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        findLongestIncreasingSubsequenceLength2(numbers);

        scanner.close();
    }

    private static void minBookMovesToSort(List<Integer> numbers) {
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            boolean is = false;
            for (int j = 0; j < i; j++) {
                if (numbers.get(i) < numbers.get(j)) {
                    is = true;
                    break;
                }
            }
            if (is) {
                newList.add(numbers.get(i));
            }
        }

        System.out.println(newList.size());
    }

    // LIS O(n^2) 동적 프로그래밍 방법
    private static void minBookMoveToSort(List<Integer> books) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(books.size(), 1));

        System.out.println("dp = " + dp);

        for (int i = 1; i < books.size(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println("dp.get(i) = " + dp.get(i));
                System.out.println("dp.get(j) = " + dp.get(j));

                System.out.println("==========================");
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                System.out.println("dp = " + dp);

                if (books.get(i) > books.get(j) && dp.get(i) < dp.get(j) + 1) {
                    dp.set(i, dp.get(j) + 1);
                }
            }
        }

        int lisLength = Collections.max(dp);
        System.out.println(books.size() - lisLength);
    }

    // LIS O(n log n) 복잡도 이진탐색을 사용한 LIS
    private static void findLengthOfLIS(List<Integer> nums) {
        List<Integer> L = new ArrayList<>();

        for (int num : nums) {
            if (L.isEmpty() || num > L.get(L.size() - 1)) {
                L.add(num);
            } else {
                int i = 0, j = L.size() - 1;
                // 이진 탐색으로 num이 들어갈 위치 찾기
                while (i < j) {
                    int mid = (i + j) / 2;
                    if (L.get(mid) < num) i = mid + 1;
                    else j = mid;
                }
                // L에서 num이 들어갈 위치에 num으로 업데이트
                L.set((L.get(i) < num) ? i + 1 : i, num);
            }
        }
        System.out.println("L = " + L);
        System.out.println("L.size() = " + (nums.size() - L.size()));
    }

    private static void findLongestIncreasingSubsequenceLength(List<Integer> numbers) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(numbers.size(), 1));

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (numbers.get(i) > numbers.get(j) && dp.get(i) < dp.get(j) + 1) {
                    dp.set(i, dp.get(j) + 1);
                }
            }
        }

        System.out.println("dp = " + dp);

        int lisLength = Collections.max(dp);
        System.out.println(lisLength);
    }

    private static void findLongestIncreasingSubsequenceLength2(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();

        for (Integer number : numbers) {
            if (list.isEmpty() || number > list.get(list.size() - 1)) {
                list.add(number);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (list.get(mid) < number) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                if (list.get(i) < number) {
                    list.set(i+1, number);
                } else {
                    list.set(i, number);
                }
            }
        }

        System.out.println("list = " + list);
    }


}
