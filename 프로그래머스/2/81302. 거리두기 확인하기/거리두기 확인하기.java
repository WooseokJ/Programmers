import java.util.*;

class Solution {
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};
    public static int[] ans = {1,1,1,1,1};
    
    public int[] solution(String[][] places) {
        int rowLen = places.length;
        int colLen = places[0].length;
        
        Character[][] grid = new Character[5][5];
        
        for(int i =0; i < 5; i++){
            String[] rooms = places[i];
            
            
            for(int r =0; r < rowLen; r++) {
                for(int c = 0; c < colLen; c++) {
                    grid[r][c] = rooms[r].charAt(c);
                }
            }
            
            for(int r =0; r < rowLen; r++) {
                for(int c = 0; c < colLen; c++) {
                    if(grid[r][c] == 'P') {
                        bfs(r,c,grid,i);
                    }
                }
            }     
        }
        
        
        return ans;
    }
    
    public static void bfs(int r, int c, Character[][] grid, int idx) {
        
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c});
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            for(int i =0; i < 4; i++) {
                int nr = curRow + dr[i];
                int nc = curCol + dc[i];
                
                if( ( 0 <= nr && nr < 5) && (0 <= nc && nc < 5) ) {                    
                    // if(visited[nr][nc]) break;
                    if(nr == r && nc == c) continue;
                    
                    int depth = Math.abs(nr - r) + Math.abs(nc - c);

                    // if(grid[nr][nc] == 'X') break;

                    if(grid[nr][nc] == 'P' && depth <= 2) {
                        ans[idx] = 0;
                        return;
                    } 
                    if(grid[nr][nc] == 'O' && depth < 2) {
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                    
                }
            }
            
        }
        
    }

    
}