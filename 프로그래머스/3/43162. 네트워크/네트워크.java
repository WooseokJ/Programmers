import java.util.*;

class Solution {
    // 이동 방향: 오른쪽, 왼쪽, 아래, 위
    public static final int[] dr = {0, 0, 1, -1};
    public static final int[] dc = {1, -1, 0, 0};

    public int solution(int n, int[][] computers) {
        int ans = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, i, visited);
                ans++;
            }
        }
        return ans;
    }

    public static void bfs(int[][] computers, int start, boolean[] visited) {
        int n = computers.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < n; i++) {
                if (computers[node][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int result = sol.solution(computers.length, computers);
        System.out.println("Number of connected components: " + result); // 예상 출력: 2
    }
}