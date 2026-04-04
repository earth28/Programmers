import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환하여 저장할 배열
        String[] arr = new String[numbers.length];
        
        // int -> String 변환
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }
        
        // 두 문자열 비교
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        // 정렬된 문자열 하나로 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        // 예외 처리
        if (sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}
