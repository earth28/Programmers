import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자 3명의 정답 패턴
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        // 각 수포자의 정답 개수 저장할 배열
        int[] score = new int[3];
        
        // 각 수포자의 정답 개수 score에 저장
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % 5]) { score[0]++; }
            if (answers[i] == p2[i % 8]) { score[1]++; }
            if (answers[i] == p3[i % 10]) { score[2]++; }
        }
        
        // 가장 높은 정답 개수 확인
        int MaxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        // 가장 많은 문제를 맞힌 수포자 리스트 생성
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (MaxScore == score[i]) { list.add(i + 1); }
        }
        
        // 리스트 -> 배열 변환
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
