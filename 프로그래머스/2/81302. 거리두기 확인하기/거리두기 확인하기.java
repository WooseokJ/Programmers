import java.util.*;

class Solution {
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};
    public static int[] ans = {1,1,1,1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = {};
        int rowLen = places.length;
        int colLen = places[0].length;
        
        for(int i = 0; i < 5; i++) {
            String[] rooms = places[i];
            
            Character[][] grid = new Character[rowLen][colLen];
            // String[][] -> Character[][] 
            for(int r = 0; r < rowLen; r++) {
                for(int c = 0; c < colLen; c++) {
                    grid[r][c] = rooms[r].charAt(c);
                }
            }

            for(int r = 0; r < rowLen; r++) {
                for(int c = 0 ; c < colLen; c++) {
                    if(grid[r][c] == 'P') {
                        bfs(grid, r,c, i);
                    }
                }
            }        
            
            
        }
        
        return ans;
        
    }
    public static void bfs(Character[][] grid, int r , int c, int idx) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(r,c, 1));
        
        boolean[][] visited = new boolean[rowLen][colLen];
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            int curRow = cur.r;
            int curCol = cur.c;
            int curStep = cur.step;
            for(int i = 0 ; i < 4 ;i++) {
                int nr = curRow + dr[i];
                int nc = curCol + dc[i];
                
                if( (0 <= nr && nr < rowLen)  && (0 <= nc && nc < colLen ) ) {
                    
                    if(visited[nr][nc]) continue;
                    if(grid[nr][nc] == 'X') continue;
                    
                    if(grid[nr][nc] == 'O') {
                        q.offer(new Point(nr,nc,curStep+1));
                        visited[nr][nc] = true;
                    }
                    if(grid[nr][nc] == 'P' && curStep <= 2) {
                        ans[idx] = 0;
                        return ;
                    }
                }
                
            }
        }
        
    }
    
    public static class Point {
        int r, c, step;
        public Point(int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
    
    
    
    public static void print(Character[][] grid) {
        for(Character[] c: grid) {
            for(Character d : c) {
                System.out.printf("%c ", d);    
            }
            System.out.println();
        }
        System.out.println();
    }
}