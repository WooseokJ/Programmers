import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int ans = 0;
        boolean[] visited = new boolean[n];
        
        for(int i =0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, computers, visited);
                ans++;
            }
        }
        
        return ans;
    }
    public static void bfs(int node, int[][] computers, boolean[] visited) {
        int rowLen = computers.length;
        visited[node] = true;
        
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < rowLen; i++) {
                if((!visited[i]) && (computers[cur][i] == 1) && (cur != i)) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

}