import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int ans = 0;
        int min = Integer.MIN_VALUE;
        Queue<Entry> pq = new PriorityQueue<>();
        for(int[] route: routes){
            int start = route[0];
            int end = route[1];
            pq.offer(new Entry(start, end));
        }
        
        while(!pq.isEmpty()) {
            Entry cur = pq.poll();
            if(cur.start > min) {
                min = cur.end;
                ans++;
            }
        }
        
        return ans;
    }
    
    public static class Entry implements Comparable<Entry> {
        int start, end;
        Entry(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Entry o) {
            return this.end - o.end;
        }
            
    }
}