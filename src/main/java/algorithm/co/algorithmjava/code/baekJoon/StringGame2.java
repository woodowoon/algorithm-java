package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 문자열 게임 2 20437번
public class StringGame2 {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 게임의 수
        for (int t = 0; t < T; t++) {
            scanner.nextLine(); // 다음 줄로 이동
            String W = scanner.nextLine().trim();
            int K = scanner.nextInt(); // 정수 K

            solve(W, K);
        }

        scanner.close();
    }

    // while (map.get(charList.get(end)) == k) 이 부분에서 NullPointException 이 발생했고, 결과적으로 map.getOrDefault(charList.get(end), 0) == k 로 수정하였는데 그건 틀렸다고 한다..
    // 테스트 케이스가 맞았는데 ㅠㅠ
    private static void logic(String w, int k) {
        int start = 0;
        int minSize = Integer.MAX_VALUE;
        int maxSize = 0;

        List<Character> charList = new ArrayList<>(w.length());

        for(Character c : w.toCharArray()) {
            charList.add(c);
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < charList.size(); end++) {
            map.put(charList.get(end), map.getOrDefault(charList.get(end), 0) + 1);

            while (map.getOrDefault(charList.get(end), 0) == k) {
                minSize = Math.min(minSize, end - start + 1);
                maxSize = Math.max(maxSize, end - start + 1);

                if (map.getOrDefault(charList.get(start), 0) == 1) {
                    map.remove(charList.get(start));
                } else if (map.getOrDefault(charList.get(start), 0) > 1) {
                    map.put(charList.get(start), map.getOrDefault(charList.get(start), 0) - 1);
                }

                start++;
            }

        }

        if (minSize == Integer.MAX_VALUE && maxSize == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minSize + " " + maxSize);
        }
    }

    private static void solve(String W, int K) {
        // 문자별 등장 위치를 저장하는 맵
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        for (int i = 0; i < W.length(); i++) {
            char c = W.charAt(i);
            charPositions.putIfAbsent(c, new ArrayList<>()); // .putIfAbsent : Key 값이 존재하는 경우 Map의 Value의 값을 반환하고, Key값이 존재하지 않는 경우 Key와 Value를 Map에 저장하고 Null을 반환합니다.
            charPositions.get(c).add(i);
        }

        int minSize = Integer.MAX_VALUE;
        int maxSize = 0;

        System.out.println("charPositions = " + charPositions);

        for (Map.Entry<Character, List<Integer>> entry : charPositions.entrySet()) {
            List<Integer> positions = entry.getValue();
            // 해당 문자가 K번 이상 등장하는 경우만 검사
            if (positions.size() >= K) {
                for (int i = 0; i + K - 1 < positions.size(); i++) {
                    int start = positions.get(i);
                    int end = positions.get(i + K - 1);

                    int length = end - start + 1;
                    minSize = Math.min(minSize, length);// K번째 문자가 마지막 문자로 등장하는 경우, maxSize 업데이트
                    maxSize = Math.max(maxSize, length);
                }
            }
        }

        if (minSize == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(minSize + " " + maxSize);
        }
    }


}
