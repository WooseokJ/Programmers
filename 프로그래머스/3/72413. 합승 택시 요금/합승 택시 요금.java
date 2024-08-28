import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<Info>> graph = new HashMap<>();
        for(int[] info : fares) {
            int curNode = info[0];
            int nextNode = info[1];
            int weight = info[2];
            graph.putIfAbsent(curNode, new ArrayList<>());
            graph.putIfAbsent(nextNode, new ArrayList<>());
            graph.get(curNode).add(new Info(nextNode, weight));
            graph.get(nextNode).add(new Info(curNode, weight));
        }
        
        int INF = Integer.MAX_VALUE;
        // 시작(s), a, b 지점 에서 x까지 다익스트라.
        int[][] visited = new int[3][n+1];
        for(int[] row: visited) {
            Arrays.fill(row, INF);
        }
        
        dijkstra(s, visited, 0,graph);
        dijkstra(a, visited, 1,graph);
        dijkstra(b, visited, 2,graph);
        
        int ans = INF;
        
        for(int i =0; i < visited[0].length; i++) {
            int sum = 0;
            for(int[] rr: visited) {
                sum += rr[i];
            }
            ans = Math.min(sum, ans);
        }
        
        return ans;
        

    }
    public static void dijkstra(int curNode, int[][] visited, int rowNum, Map<Integer, List<Info>> graph) {
        Queue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(curNode, 0));
        visited[rowNum][curNode] = 0;
        
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(visited[rowNum][cur.node] < cur.weight) continue;
            if(graph.containsKey(cur.node)) {
                for(Info next: graph.get(cur.node)) {
                    int totalWeight = next.weight + cur.weight;
                    if(totalWeight < visited[rowNum][next.node]) {
                        visited[rowNum][next.node] = totalWeight;
                        pq.add(new Info(next.node, totalWeight));
                    }
                }
            }
        }
        
    }
    public static class Info implements Comparable<Info> {
        int node, weight;
        public Info(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        @Override
        public int compareTo(Info o) {
            return this.weight - o.weight;
        }
    }
}