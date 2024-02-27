package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// DNA 비밀번호 12891
public class DNAPassword {
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int p = scanner.nextInt();

        // 문자열 List 로 입력 받기
        String data = scanner.next();
        List<Character> dataList = new ArrayList<>();

        for (char c : data.toCharArray()) { // 문자열을 문자 배열로 변환 후 순회
            dataList.add(c); // 각 문자를 리스트에 추가
        }

        // 조건 Map 으로 입력 받기
        Map<Character, Integer> rule = new HashMap<>();
        List<Character> DNA = Arrays.asList('A', 'C', 'G', 'T');
        for (Character value : DNA) {
            rule.put(value, scanner.nextInt());
        }

        scanner.close();

        logic(dataList, rule, p);
    }

    private static void logic(List<Character> dataList, Map<Character, Integer> rule, Integer p) {
        Map<Character, Integer> actualCounts = new HashMap<>();
        int count = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < p; i++) {
            actualCounts.put(dataList.get(i), actualCounts.getOrDefault(dataList.get(i), 0) + 1);
        }

        System.out.println("actualCounts = " + actualCounts);

        int start = 0;
        for (int end = p; end <= dataList.size(); end++) {
            if (meetsCriteria(actualCounts, rule)) {
                count++;
            }

            // 윈도우를 오른쪽으로 이동시킵니다.
            if (end != dataList.size()) { // 마지막 순서가 아니라면,
                actualCounts.put(dataList.get(end), actualCounts.getOrDefault(dataList.get(end), 0) + 1);
            }
            actualCounts.put(dataList.get(start), actualCounts.get(dataList.get(start)) - 1);

            // 만약 특정 문자의 개수가 0이 되면, 맵에서 제거합니다.
            if (actualCounts.get(dataList.get(start)) == 0) {
                actualCounts.remove(dataList.get(start));
            }
            start++;
        }

        System.out.println(count);
    }

    private static boolean meetsCriteria(Map<Character, Integer> actualCounts, Map<Character, Integer> rule) {
        for (Map.Entry<Character, Integer> entry : rule.entrySet()) {
            if (actualCounts.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    // 시간초과 된 문제
    private static void logic2(List<Character> dataList, Map<Character, Integer> rule, Integer p) {
        List<Character> currentData = new ArrayList<>();
        int count = 0;

        for (Character character : dataList) {
            currentData.add(character);

            if (currentData.size() == p) {
                Map<Character, Integer> actualCounts = new HashMap<>();

                // for 문 돌면서 각각의 데이터가 몇개씩 출연했는지 알아보기
                for (char c : currentData) {
                    actualCounts.put(c, actualCounts.getOrDefault(c, 0) + 1);
                }

                boolean allRulesPassed = true;
                for (Map.Entry<Character, Integer> entry : rule.entrySet()) {
                    char key = entry.getKey();
                    int requiredCount = entry.getValue();

                    // 실제 개수가 규칙에서 요구하는 최소 개수보다 적은 경우 통과하지 못함
                    if (actualCounts.getOrDefault(key, 0) < requiredCount) {
                        allRulesPassed = false;
                    }
                }

                if (allRulesPassed) {
                    count++;
                }

                currentData.remove(0);
            }
        }

        System.out.println(count);
    }

    // 좀 더 익숙한 방식으로 푼 문제
    private static void logic3(List<Character> dataList, Map<Character, Integer> rule, Integer p) {
        // 1. p 개수만큼 더한다.
        Map<Character, Integer> current = new HashMap<>();
        int count = 0;
        int start = 0;

        for (int end = 0; end < dataList.size(); end++) {
            current.put(dataList.get(end), current.getOrDefault(dataList.get(end), 0) + 1);

            if (end >= p - 1) {
                if (meetsCriteria(current, rule)) {
                    count++;
                }

                current.put(dataList.get(start), current.get(dataList.get(start)) - 1);

                if (current.get(dataList.get(start)) == 0) {
                    current.remove(dataList.get(start));
                }

                start++;
            }
        }

        System.out.println(count);
    }
}
