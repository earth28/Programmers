import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        
        List<String> spoilerWords = new ArrayList<>();
        Set<String> normalWords = new HashSet<>();
        
        // 현재 탐색 위치
        int idx = 0;
        
        // 단어 단위로 분리
        for (String word : message.split(" ")) {
            
            int start = message.indexOf(word, idx);
            int end = start + word.length() - 1;
            
            idx = end + 1;
            
            boolean isSpoiler = false;
            
            // 스포 범위와 겹치는지 검사
            for (int[] range : spoiler_ranges) {
                
                if (start <= range[1] && end >= range[0]) {
                    isSpoiler = true;
                    break;
                }
            }
            
            // 스포 단어 / 일반 단어 분류
            if (isSpoiler) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }
        }
        
        // 중요한 단어 판별
        int answer = 0;
        Set<String> used = new HashSet<>();
        
        for (String word : spoilerWords) {
            
            // 일반 구간에 등장한 적 없고
            // 이전 스포 단어와 중복되지 않으면
            if (!normalWords.contains(word) &&
                !used.contains(word)) {
                
                answer++;
                used.add(word);
            }
        }
        
        return answer;
    }
}