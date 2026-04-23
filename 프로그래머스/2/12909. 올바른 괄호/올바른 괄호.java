import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        // 문자열 순회
        for (char i : s.toCharArray()) {
            if (i == '(') { // 여는 괄호는 스택에 저장
                stack.push(i);
            }
            else {
                if (stack.isEmpty()) {  // 닫는 괄호인데 스택이 비어있으면 실패
                    return false;
                }
                stack.pop();    // 짝이 맞으므로 pop
            }
        }
        
        // 모든 괄호가 짝지어졌으면 스택이 비어있어야 함
        return stack.isEmpty();
    }
}