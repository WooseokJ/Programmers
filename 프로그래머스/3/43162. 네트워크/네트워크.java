class Solution {
    public int solution(int n, int[][] computers) {
        int ans = 0;
        boolean[] visited= new boolean[n]; // 노드 개수만큼 방문여부 체크  
        for(int i= 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i,visited, computers); // 해당노드에 연결된거 dfs 
                ans++; // +1
            }
        }
        
        return ans;
    }
    public static void dfs(int node, boolean[] visited, int [][] computers) {
        visited[node] = true; // 현재노드 처리 
        for(int next = 0; next < computers.length; next++) {
            if(computers[node][next] == 1) {
                if(!visited[next]) {
                    dfs(next, visited, computers);
                }
            }

        }
    }
}