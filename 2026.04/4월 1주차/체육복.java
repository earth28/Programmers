import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 배열 -> Set 변환
        // 빠른 탐색/삭제를 위해 사용
        Set<Integer> lostSet = new HashSet<>();
        for (int l : lost) lostSet.add(l);
        
        Set<Integer> reserveSet = new HashSet<>();
        for (int r : reserve) reserveSet.add(r);
        
        int answer = 0; // 체육복 못 빌린 학생 수
        
        // 교집합 구하기
        Set<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet);
        
        // 교집합 제거
        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);
        
        // 도난 당한 학생 기준 순회
        for (int student : lostSet) {
            
            // 앞 번호 학생에게 빌릴 수 있는 경우
            if (reserveSet.contains(student - 1)) {
                reserveSet.remove(student - 1);
            }
            
            // 앞에서 못 빌렸으면 뒷 번호 확인
            else if (reserveSet.contains(student + 1)) {
                reserveSet.remove(student + 1);
            }
            
            // 둘 다 안되면 못 빌림
            else {
                answer++;
            }
        }
        
        // 전체 학생 수 - 못 빌린 학생 수
        return n - answer;
    }
}
