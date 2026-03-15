import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] w = new int[sizes.length];
        int[] h = new int[sizes.length];
        
        // 두 변 중 긴 것은 가로, 짧은 것은 세로로 저장
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                w[i] = sizes[i][0];
                h[i] = sizes[i][1];
            }
            else {
                w[i] = sizes[i][1];
                h[i] = sizes[i][0];
            }
        }
        
        // 각 배열 정렬 후 가장 큰 값끼리의 곱이 answer
        Arrays.sort(w);
        Arrays.sort(h);
        
        return answer = w[w.length - 1] * h[h.length - 1];
    }
}
