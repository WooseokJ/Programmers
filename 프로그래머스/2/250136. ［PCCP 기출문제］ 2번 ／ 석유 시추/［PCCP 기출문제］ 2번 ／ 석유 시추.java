import java.util.*;
class Solution {
    static int[] oil;
    public int solution(int[][] land) {
        int ans[] = {0};
        int rowLen = land.length;
        int colLen = land[0].length;
        List<List<Point>> pArr = new ArrayList<>();
        boolean[][] visited = new boolean[rowLen][colLen];
        oil = new int[colLen];
        
        for(int r =0; r < rowLen; r++) {
            for(int c =0; c < colLen; c++) {
                if(!visited[r][c] && land[r][c] == 1) {
                    int i = dfs(r,c,land, visited, ans, pArr);  
                    
                }
            }
        }
    
        int sum = 0;
        for(int c = 0; c < colLen; c++) {
            sum = Math.max(sum, oil[c]);
               
        }
        
 
        
        return sum;
    }
    public static int dfs(int r, int c, int[][] land, boolean[][] visited, int[] ans, List<List<Point>> pArr) {
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        int rowLen = land.length;
        int colLen = land[0].length;
        
        int cnt = 1;
        
        visited[r][c] = true;
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(r,c));
        List<Point> temp = new ArrayList<>();
        temp.add(new Point(r,c));
        Set<Integer> set = new HashSet<>();

        while(!q.isEmpty()) {
                Point cur = q.poll();
            set.add(cur.c);
            for(int i =0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(( 0<= nr && nr < rowLen) && (0 <= nc && nc < colLen) ) {
                    if(!visited[nr][nc] && land[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        Point p = new Point(nr,nc);
                        q.offer(p);
                        cnt++;
                        temp.add(new Point(nr,nc));
                    } 
                }
            }
        }
        pArr.add(temp);
        for(int idx: set) {
            oil[idx] +=cnt;
        }
        
        return cnt;
        
    }
    public static class Point {
        int r,c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }


}
// 세로n, 가로 m
// 