import java.util.*;

class Solution {
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};
    
    public int[] solution(String[][] places) {

        int[] ans = new int[5];
        
        for(int i =0; i < 5; i++) {
            String[] rooms = places[i];
            boolean flag = true;
            
            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    if(rooms[r].charAt(c) == 'P') {
                        if(!bfs(r,c,rooms)) {
                            flag = false;
                        }
                    }
                }
            }
            
            ans[i] = flag ? 1 :  0;
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
                int nr = curRow + dr[i];
                int nc = curCol + dc[i];
                
                  if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
                    continue;
                
                // if(isValid(nr, nc, rooms)) {
                    int depth = Math.abs(nr - r) + Math.abs(nc - c);

                    if(depth <= 2 && rooms[nr].charAt(nc) == 'P') {
                        System.out.println(depth);
                        return false;
                    } else if( depth < 2  && rooms[nr].charAt(nc) == 'O') {
                        q.offer(new int[]{nr,nc});
                    }
                    
                    
                    
                // }
                
            }
            
        }
        return true;
        
    }
    public static boolean isValid(int r, int c, String[] rooms) {
        return ( (0 <= r && r < 5) && (0 <=c && c < 5) );
    }
}