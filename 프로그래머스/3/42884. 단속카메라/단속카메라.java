import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int ans = 0;
        int cam = Integer.MIN_VALUE;
        Queue<Info> pq = new PriorityQueue<>();
        
        for(int[] route: routes) {
            pq.offer(new Info(route[0], route[1]));
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
            return this.end - o.end; // 오름차순.
            
        }
    }
}



// -20 ~~~~            -15
//                          -14  ~~~~~~~ - 5
//     -18~~ ~                  -13
//                                        -5 ~ -3