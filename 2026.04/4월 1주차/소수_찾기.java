import java.util.*;

class Solution {
    // 만들어진 숫자들을 중복 없이 저장
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        dfs("", new boolean[numbers.length()], numbers);
        int answer = 0;
        
        // 만들어진 숫자 중 소수 개수 세기
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(String current, boolean[] visited, String numbers) {
        // 하나의 숫자가 만들어질 때마다 set에 저장
        // 빈 문자열은 제외
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            set.add(num);
        }
        
        // 모든 자리 숫자를 하나씩 붙여보기
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {  // 아직 사용하지 않은 자리라면
                visited[i] = true;  // 사용 처리
                
                // 현재 숫자 뒤에 새로운 숫자 추가
                dfs(current + numbers.charAt(i), visited, numbers);
                visited[i] = false; // 다시 되돌리기
            }
        }
    }
    
    boolean isPrime(int num) {
        if (num < 2) return false;  // 0, 1은 소수 아님
        
        // 2 ~ num의 제곱근까지만 검사
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}
