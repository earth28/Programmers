import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> day = new LinkedList<Integer>(); // 각 기능이 배포되기까지 걸리는 일수(완료일)을 저장하는 큐
        
        for (int i = 0; i < progresses.length; i++) {
            day.offer((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }
        
        int count = 1;  // 현재 배포 그룹에 포함된 기능 개수
        int day1 = day.poll();  // 현재 배포 기준이 되는 완료일
        List<Integer> result = new ArrayList<>();
        
        // 다음 기능이 현재 기준일 안에 배포 가능한지 확인
        while (!day.isEmpty()) {
            // 다음 기능이 현재 배포일 안에 완료되면 함께 배포
            if (day1 >= day.peek()) {
                count++;
                day.poll();
            }
            
            // 새로운 배포가 필요 -> 기존 그룹 저장 후 새 기준 설정
            else {
                result.add(count);
                day1 = day.poll();
                count = 1;
            }
        }
        
        result.add(count);  // 마지막 count 추가
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
