package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 23757번 아이들과 선물상자
public class KidsGiftBox {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        PriorityQueue<Integer> giftQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            giftQueue.offer(scanner.nextInt());
        }
        
        List<Integer> kids = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            kids.add(scanner.nextInt());
        }
        
        scanner.close();

        System.out.println(logic(giftQueue, kids));
    }

    private static int logic(PriorityQueue<Integer> giftQueue, List<Integer> kids) {
        for (Integer kid : kids) {
            if (giftQueue.isEmpty()) {
                return 0;
            }

            Integer gift = giftQueue.poll();
            if (gift < kid) {
                return 0;
            } else {
                int dic = gift - kid;
                if (dic != 0) {
                    giftQueue.offer(dic);
                }
            }
        }

        return 1;
    }

}
