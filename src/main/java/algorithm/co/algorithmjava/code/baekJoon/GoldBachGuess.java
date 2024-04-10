package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 6588번 골드바흐의 추측
public class GoldBachGuess {

    private static final String WRONG = "Goldbach's conjecture is wrong.";

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number != 0) {
                numbers.add(number);
            } else {
                break;
            }
        }

        scanner.close();

        Map<Integer, List<Integer>> logic = logic(numbers);

        for (Integer number : numbers) {
            List<Integer> value = logic.get(number);

            if (value == null) {
                sb.append(WRONG).append("\n");
            } else {
                sb.append(number).append(" = ").append(Collections.min(value)).append(" + ").append(Collections.max(value)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static Map<Integer, List<Integer>> logic(List<Integer> numbers) {
        Map<Integer, List<Integer>> answer = new HashMap<>();

        Integer maxNumber = Collections.max(numbers);
        List<Integer> primeNumbers = findPrimeNumber(maxNumber);

        for (Integer number : numbers) {
            List<Integer> sumNumber = findSumNumber(number, primeNumbers);

            answer.put(number, sumNumber);
        }

        return answer;
    }

    private static List<Integer> findSumNumber(Integer number, List<Integer> primeNumbers) {
        List<Integer> answer = new ArrayList<>();
        int maxDissidence = -1;
        int number1 = 0;
        int number2 = 0;

        for (Integer primeNumber : primeNumbers) {
            int complement = number - primeNumber;
            if (primeNumbers.contains(complement)) {
                int dissidence = Math.abs(primeNumber - complement);
                if (dissidence > maxDissidence) {
                    maxDissidence = dissidence;
                    number1 = primeNumber;
                    number2 = complement;
                }
            }
        }

        if (maxDissidence != -1) {
            answer.add(number1);
            answer.add(number2);
        }

        return answer;
    }

    private static List<Integer> findPrimeNumber(Integer number) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i < number; i++) {
            if (isPrimeNumberAndExcluding2(i)) primeNumbers.add(i);
        }

        return primeNumbers;
    }

    // 소수 경우의 수에서 2도 제외(홀수만 찾아야하기때문에.)
    private static Boolean isPrimeNumberAndExcluding2(Integer number) {
        if (number <= 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
