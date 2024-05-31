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
            
            boolean flag = false;
            for(int r =0; r < rowLen; r++) {
                for(int c = 0; c < colLen; c++) {
                    grid[r][c] = rooms[r].charAt(c);
                }
            }
            
            for(int r =0; r < rowLen; r++) {
                for(int c = 0; c < colLen; c++) {
                    if(grid[r][c] == 'P') {
                        if(bfs(r,c,rooms)) {
                            flag = true;
                        }
                    }
                }
            }     
            ans[i] = flag ? 0 : 1;
        }
        
        
        return ans;
    }
    
    public static boolean bfs(int r, int c, String[] rooms) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            for(int i =0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                
                if(isValid(nextRow, nextCol, rooms)) {
                    if(nextRow == r && nextCol == c) {
                        continue;
                    }
                    int depth = Math.abs(nextRow - r) + Math.abs(nextCol - c);
                    if(depth <= 2 && rooms[nextRow].charAt(nextCol) == 'P') {
                        return true;
                    } else if( depth < 2  && rooms[nextRow].charAt(nextCol) == 'O') {
                        q.offer(new int[]{nextRow, nextCol});
                    }
                  
                }
                 
                
            }
            
        }
        return false;
        
    }
    public static boolean isValid(int r, int c, String[] rooms) {
        return ( (0 <= r && r < 5) && (0 <=c && c < 5) );
    }
    
}