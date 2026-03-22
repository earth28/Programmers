import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i : scoville) {
            heap.offer(i);
        }
        
        // heap의 최솟값이 K 이상일 때까지 반복
        while (heap.peek() < K) {
            // 힙에 원소가 한 개 밖에 없다면 -1 반환
            if (heap.size() < 2) {
                return -1;
            }
            
            // 힙의 두 최솟값을 사용해 새로운 스코빌 지수 계산 후 offer
            int s1 = heap.poll();
            int s2 = heap.poll();
            
            heap.offer(s1 + s2 * 2);
            
            answer++;   // 카운트 증가
        }
        
        return answer;
    }
}
