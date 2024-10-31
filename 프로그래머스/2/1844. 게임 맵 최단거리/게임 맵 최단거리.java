import java.util.*;

class Solution {
    static int rowLen;
    static int colLen;
    public int solution(int[][] maps) {
        int ans = 0;
        rowLen = maps.length;
        colLen = maps[0].length;
        
        boolean[][] visited = new boolean[rowLen][colLen];
        ans = bfs(visited, maps);
        
        
        return ans;
    }
    public static int bfs(boolean[][] visited, int[][] maps) {
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        
        visited[0][0] = true;
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(0,0,1));
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i =0 ;i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
          
                
                if((0<=nr && nr < rowLen) && (0 <= nc && nc < colLen)) {
                    if(maps[nr][nc] == 1 && nr == rowLen-1 && nc == colLen-1) {
                        return cur.step+1;
                    }
                    
                    if(!visited[nr][nc] && maps[nr][nc] == 1) {
                        q.offer(new Point(nr,nc,cur.step+1));
                        visited[nr][nc] = true;
                            
                    }
                }
            }
        }
        
        return -1;
    }
    public static class Point {
        int r, c, step;
        Point(int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
}