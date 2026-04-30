class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        // 문자열 시간을 초로 변환
        int video = toSec(video_len);
        int current = toSec(pos);
        int opS = toSec(op_start);
        int opE = toSec(op_end);
        
        // 초기 오프닝 스킵 체크
        if (current >= opS && current <= opE) {
            current = opE;
        }
        
        // 명령 처리
        for (String cmd : commands) {
            
            if (cmd.equals("next")) {
                current += 10;
            } else {
                current -= 10;
            }
            
            // 범위 보정
            if (current < 0) current = 0;
            if (current > video) current = video;
            
            // 오프닝 스킵 체크
            if (current >= opS && current <= opE) {
                current = opE;
            }
        }
        
        // 초 → MM:SS 변환
        int m = current / 60;
        int s = current % 60;
        
        return String.format("%02d:%02d", m, s);
    }
    
    // 문자열 "MM:SS" → 초 변환
    private int toSec(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}