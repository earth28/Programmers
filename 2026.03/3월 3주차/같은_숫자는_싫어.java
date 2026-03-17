import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        // stack이 비어있거나 가장 위의 값과 num이 다르다면 num 스택에 추가
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        
        // stack에 저장된 값을 배열에 저장
        int[] answer = new int[stack.size()];
        
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }
        
        return answer;
    }
}
