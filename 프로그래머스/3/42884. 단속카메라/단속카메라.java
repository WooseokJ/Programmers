import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        
        int ans =0;
        int cam = Integer.MIN_VALUE;
        
        Queue<Info> pq = new PriorityQueue<>();
        for(int[] r: routes) {
            pq.offer(new Info(r[0], r[1]));
        }
        
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(cam < cur.start) {
                cam = cur.end;
                ans++;
            }
        }
        return ans;
            
    }
    public static class Info implements Comparable<Info>{
        int start, end;
        Info(int start, int end){
            this.start = start;
            this.end = end;
            
        }
        @Override
        public int compareTo(Info o) {
            return this.end - o.end;
        }
            
        
    }
}