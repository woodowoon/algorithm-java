package algorithm.co.algorithmjava.code.gpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 카다인 (케이든스)
public class Kadane {

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        List<String> numberStr = List.of(br.readLine().split(" "));

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(numberStr.get(i)));
        }

        maxProfitFromStocks(numbers);

        br.close();
    }

    private static void maxSumOfConsecutiveNumbers(List<Integer> numbers) {
        System.out.println("numbers = " + numbers);
        int currentSum = 0; // 현재 부분 배열의 합
        int maxSum = Integer.MIN_VALUE; // 지금까지 발견된 최대 합

        for (int number : numbers) {
            currentSum = Math.max(number, currentSum + number); // 현재 숫자를 포함하는 것이 더 나은지 확인 Math.max 는 두 값이 같으면 아무거나 반환
            maxSum = Math.max(maxSum, currentSum); // 최대 합 갱신
        }

        System.out.println(maxSum);
    }

    private static void maxProfitFromStocks(List<Integer> prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // 현재 가격에서 최소 가격을 빼서 최대 이익을 갱신
            maxProfit = Math.max(maxProfit, price - minPrice);
            // 최소 가격 갱신
            minPrice = Math.min(minPrice, price);
        }

        System.out.println(maxProfit);
    }

    private static void maxProductOfSubarray(List<Integer> numbers) {
        // 첫 번째 요소로 초기화
        int maxProd = numbers.get(0);
        int minProd = numbers.get(0);
        int result = maxProd;

        for (int i = 1; i < numbers.size(); i++) {
            int num = numbers.get(i);
            // 음수일 경우 최대값과 최소값을 바꿔야 할 수 있으므로, temp 변수 사용
            int tempMax = Math.max(num, Math.max(maxProd * num, minProd * num));
            minProd = Math.min(num, Math.min(maxProd * num, minProd * num));

            maxProd = tempMax;
            result = Math.max(result, maxProd);
        }

        System.out.println(result);
    }


}
