class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        // 좌우 이동 기본값 (오른쪽으로만 가는 경우)
        int move = n - 1;
        
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            
            // 알파벳 변경 비용
            answer += Math.min(c - 'A', 'Z' - c + 1);
            
            // A 연속 구간 찾기
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            // 커서 이동 최소값 갱신
            move = Math.min(move, i * 2 + (n - next));
            move = Math.min(move, i + 2 * (n - next));
        }
        
        return answer + move;
    }
}