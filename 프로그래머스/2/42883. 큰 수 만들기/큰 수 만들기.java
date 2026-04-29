import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char c : number.toCharArray()) {
            
            // 현재 숫자가 더 크면 이전 작은 숫자 제거
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {  // (A)
                stack.pop();
                k--;
            }
            
            // 현재 숫자 추가
            stack.push(c);
        }
        
        // 아직 제거할 게 남았다면 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 결과 만들기
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}