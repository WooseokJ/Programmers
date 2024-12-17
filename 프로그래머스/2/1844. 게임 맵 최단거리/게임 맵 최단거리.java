import java.util.*;
class Solution {
    int ans = 0;
    public int solution(int[][] maps) {
        
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(0,0,visited,maps);
    }
    public static int bfs(int r, int c, boolean[][] visited, int[][] maps) {
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        Deque<Integer[]> q = new ArrayDeque<>();
        q.offer(new Integer[]{r,c,1});
        visited[r][c] = true;
        while(!q.isEmpty()) {
            Integer[] cur = q.poll();
            for(int i= 0; i <4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if( (0 <= nr && nr < maps.length)  && (0 <= nc && nc < maps[0].length) ) {
                    if(!visited[nr][nc] && maps[nr][nc] == 1) {
                        // System.out.println(nr + " " + nc + " " + cur[2] + " " +maps.length + " " );
                        if(nr == maps.length-1 && nc == maps[0].length - 1) {
                            return cur[2] + 1 ;
                        }
                        visited[nr][nc] = true;
                        q.offer(new Integer[]{nr, nc, cur[2] + 1});
                        
                    }
                }
            }
        }
        
        return -1;
        
    }
}