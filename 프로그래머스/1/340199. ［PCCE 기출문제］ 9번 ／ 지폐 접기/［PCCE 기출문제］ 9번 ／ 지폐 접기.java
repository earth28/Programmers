import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 짧은 변, 긴 변 순으로 정렬
        Arrays.sort(wallet);
        Arrays.sort(bill);
        
        // 지폐가 지갑보다 큰 동안 반복
        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            bill[1] = bill[1] / 2;  // 더 긴 변을 반으로 접기
            Arrays.sort(bill);  // 다시 짧은 변, 긴 변 순으로 정렬
            answer++;   // 접은 횟수 증가
        }   
        
        // 최소 접기 횟수 반환
        return answer;
    }
}