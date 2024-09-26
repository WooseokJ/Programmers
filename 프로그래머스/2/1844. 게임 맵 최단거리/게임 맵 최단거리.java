import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int ans = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        ans = bfs(visited,maps);
        
        return ans;
    }
    public static int bfs(boolean[][] visited, int [][] maps) {
        int rowLen = maps.length;
        int colLen = maps[0].length;
        visited[0][0] = true;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0,0,1));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int curRow = cur.r;
            int curCol = cur.c;
            int curStep = cur.step;
            for(int i =0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                
                if(isValid(nextRow, nextCol, rowLen, colLen)) {
                    if(maps[nextRow][nextCol] == 1) {
                        if(!visited[nextRow][nextCol]) {
                            if(nextRow == rowLen-1 && nextCol == colLen-1) {
                                
                                return curStep+1;
                            }
                            visited[nextRow][nextCol] = true;
                            q.offer(new Pair(nextRow, nextCol, curStep+1));
                            
                        }                       
                    }
                 
                }
            }
        }
        return -1;
        
        
    }
    public static boolean isValid(int r, int c, int rowLen, int colLen) {
        
        return (( 0<= r && r < rowLen) && (0 <= c && c < colLen));
    }
    public static class Pair {
        int r, c, step;
        public Pair(int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
        
    }
    
    
}