import java.util.*;
class Solution {
    
    // 1~n 개 노드 
    // fares = u <->v w
    // 반환: 최저 금액 리턴.
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 무방향그래프 
        Map<Integer, List<Info>> graph = new HashMap<>();
        for(int[] info: fares) {
            int u = info[0];
            int v = info[1];
            int w = info[2];
            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());
            graph.get(u).add(new Info(v, w));
            graph.get(v).add(new Info(u,w));
        }
        
        // 각행은 s,a,b에서의 최소비용을 담은 리스트
        int INF = Integer.MAX_VALUE;
        int[][] visited = new int[3][n+1];
        for(int[] d: visited) {
            Arrays.fill(d, INF);    
        }
        
        // 각각 다익스트라 수행.
        dijkstra(s,visited,0, graph);
        dijkstra(a,visited,1, graph);
        dijkstra(b,visited,2, graph);
        
        // ans는 최소비용.
        int ans = Integer.MAX_VALUE;
        for(int i =0; i< n+1;i++) {
            int temp = 0;
            for(int[] row: visited) {
                int xMinCost = row[i];
                temp += xMinCost;
            }
            ans = Math.min(ans,temp);
        }
        
        
        return ans;
    }
    
    public static void dijkstra(int pos, int[][] visited, int idx, Map<Integer, List<Info>> graph) {
        Queue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(pos, 0));
        visited[idx][pos] = 0;

        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(visited[idx][cur.node] < cur.weight) continue;
            if(graph.containsKey(cur.node)) {
                List<Info> arr = graph.get(cur.node);
                for(Info next: arr) {
                    int newWeight = next.weight + cur.weight;
                    if(newWeight < visited[idx][next.node]) {
                        visited[idx][next.node] = newWeight;
                        pq.add(new Info(next.node, newWeight));
                    }
                }
            }
        
        }
    }
    
    public static class Info implements Comparable<Info>{
        int node;
        int weight;
        public Info(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        @Override
        public int compareTo(Info o) {
            return this.weight - o.weight; //최소힙.
        }
    }
}