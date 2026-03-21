import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 배열 정렬
        Arrays.sort(phone_book);

        // 앞 번호가 다음 번호의 prefix인지 확인
        // startsWith() : 대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크하는 함수
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}
