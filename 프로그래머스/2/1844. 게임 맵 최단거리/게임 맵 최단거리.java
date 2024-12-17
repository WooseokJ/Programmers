import java.util.*;
class Solution {
    static int ans = 0;
    public int solution(int[][] maps) {
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        bfs(0,0,maps, visited);
        
        return ans;
    }
    public static void bfs(int r, int c, int[][] maps, boolean[][] visited) {
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c,1});
        visited[r][c] = true;
        while(!q.isEmpty()) {
            
            int[] cur =q.poll();
            for(int i= 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if( (0 <= nr && nr < maps.length) && (0<= nc && nc < maps[0].length) ) {
                    if(!visited[nr][nc] && maps[nr][nc] == 1) {
                        // System.out.println(nr + " " + nc + " " + cur[2]);
                        if(nr == maps.length-1 && nc == maps[0].length-1) {
                            ans = cur[2]+1;
                            return;
                        }
                        
                        visited[nr][nc] = true;
                        
                        q.offer(new int[]{nr,nc,cur[2]+1});
                    }
                }
                
                
            }
            
        }
        
        ans = -1;
        return ;
    }
}