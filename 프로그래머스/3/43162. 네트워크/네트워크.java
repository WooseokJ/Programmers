import java.util.*;

class Solution {
    static int ans = 0;
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n]; // 방문 
        
        for(int i = 0;i < computers.length; i++) {
            if(!visited[i]) {
                bfs(i, visited, computers, n);
                ans++;
            }
        }
        
        
        return ans;
    }
    public static void bfs(int startNode, boolean[] visited, int[][] computers, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(startNode);
        visited[startNode] = true;
        
        while(!q.isEmpty()) {
            int curNode = q.poll();
            for(int nextNode = 0; nextNode < n; nextNode++) {
                if((!visited[nextNode]) && (computers[curNode][nextNode] == 1)) {
                    visited[nextNode] = true;
                    q.offer(nextNode);
                }
            }
            
        }
    }
}