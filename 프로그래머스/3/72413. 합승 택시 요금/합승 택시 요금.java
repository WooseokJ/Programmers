import java.util.*;
class Solution {
    
    // 1~n 개 노드 
    // fares = u <->v w
    // 반환: 최저 금액 리턴.
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int ans = Integer.MAX_VALUE;
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
        
        int INF = Integer.MAX_VALUE;
        int[][] visited = new int[3][n+1];
        for(int[] d: visited) {
            Arrays.fill(d, INF);    
        }
        Queue<Info> pq = new PriorityQueue<>();
        int[] arr = {s,a,b};
        for(int i = 0; i < 3;i++) {
            dijkstra(arr[i],visited,i, graph,pq);    
        }

        // for(int[] d: visited) {
        //     for(int z :d) {
        //         System.out.printf("%d ", z);
        //     }
        //     System.out.println();
        // }        

        for(int i =0; i< n+1;i++) {
            int sum = 0;
            for(int[] d: visited) {
                sum += d[i];
            }
            ans = Math.min(sum, ans);
        }
        
        
        return ans;
    }
    
    public static void dijkstra(int s, int[][] visited, int idx, Map<Integer, List<Info>> graph, Queue<Info> pq) {
        pq.offer(new Info(s, 0));
        // pq.offer(new Info(a,0));
        // pq.offer(new Info(b,0));
        visited[idx][s] = 0;
        // visited[a] = 0;
        // visited[b] = 0;

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