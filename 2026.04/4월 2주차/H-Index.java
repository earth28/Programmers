import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        
        int n = citations.length;
        
        // 조건 확인
        for (int i = 0; i < n; i++) {
            int h = n - i;  // 현재 위치부터 끝까지 남은 논문 개수
            
            // 조건 :
            // 현재 논문의 인용 횟수가 h 이상이면 만족
            if (citations[i] >= h) {
                return h;   // 조건을 만족하는 최대 h 반환
            }
        }
        
        return 0;   // 어떤 경우에도 조건을 만족하지 못하면 0
    }
}
