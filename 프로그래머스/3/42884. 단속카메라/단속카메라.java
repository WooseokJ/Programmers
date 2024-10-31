import java.util.*;

class Solution {
    public int solution(int[][] routes) {
				int ans =0;
        int cam = Integer.MIN_VALUE;
        
        Queue<Info> pq = new PriorityQueue<>();
        for(int[] route: routes){
            int start = route[0];
            int end = route[1];
            pq.offer(new Info(start, end));
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
    
    
    
    public static class Info implements Comparable<Info> {
        int start, end;
        Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Info o) {
            return this.end - o.end;
        }
            
    }
}