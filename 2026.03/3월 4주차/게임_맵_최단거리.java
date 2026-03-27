import java.util.*;

class Solution {
    // 상하좌우 이동 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    // 시작점으로부터 각 위치까지의 최단 거리 저장
    static int[][] dist;
    
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        
        dist = new int[row][col];   // 거리 배열 초기화
        
        path(maps, row, col);
        
        // 도착 지점에 도달하지 못한 경우 -1 반환
        // dist 값이 0이면 방문하지 못한 것
        return dist[row - 1][col - 1] == 0 ? -1 : dist[row - 1][col - 1];
    }
    
    static void path(int[][] maps, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        // 시작 위치 (0,0) 큐에 추가
        queue.offer(new int[] {0, 0});
        dist[0][0] = 1; // 시작점 거리 1로 설정

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] now = queue.poll();   // 현재 위치
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];    // 다음 행
                int ny = now[1] + dy[i];    // 다음 열
                
                // 배열 범위 안인지 확인
                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    // 이동 가능한 길(1)인지 확인 및 아직 방문하지 않은 곳(dist == 0)인지 확인
                    if (maps[nx][ny] == 1 && dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;    // 현재 위치까지 거리 + 1
                        queue.offer(new int[] {nx, ny});    // 다음 탐색을 위해 큐에 추가
                    }
                }
            }
        }
    }
}
