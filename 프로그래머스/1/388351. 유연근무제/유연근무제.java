import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            
            // 출근 인정 마감 시각 계산
            int limit = addTen(schedules[i]);
            
            boolean success = true;
            
            // 7일 확인
            for (int j = 0; j < 7; j++) {
                
                int day = (startday + j - 1) % 7 + 1;
                
                // 주말이면 건너뛰기
                if (day == 6 || day == 7) {
                    continue;
                }
                
                // 출근 시간이 마감 시각보다 늦으면 실패
                if (timelogs[i][j] > limit) {
                    success = false;
                    break;
                }
            }
            
            // 상품 대상자 수 증가
            if (success) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 시각에 10분 더하는 함수
    private int addTen(int time) {
        
        int hour = time / 100;
        int minute = time % 100;
        
        minute += 10;
        
        if (minute >= 60) {
            hour++;
            minute -= 60;
        }
        
        return hour * 100 + minute;
    }
}