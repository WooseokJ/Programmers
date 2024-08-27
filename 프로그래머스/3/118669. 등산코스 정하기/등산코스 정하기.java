import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Map<Integer, List<Info>> graph = new HashMap<>();
        for(int[] path: paths) {
            int curNode = path[0];
            int nextNode = path[1];
            int weight = path[2];
            graph.putIfAbsent(curNode, new ArrayList<>());
            graph.putIfAbsent(nextNode, new ArrayList<>());
            graph.get(curNode).add(new Info(nextNode, weight));
            graph.get(nextNode).add(new Info(curNode, weight));
        }
        
        int[] visited = new int[n+1]; 
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        Queue<Info> pq = new PriorityQueue<>();
        for(int gate: gates) {
            pq.offer(new Info(gate, 0));
            visited[gate] = 0; // 방문처리
        }
        
        outer: while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(visited[cur.node] < cur.weight) continue outer;
            for(int summit: summits) {
                if(summit == cur.node) continue outer;
            }
            
            if(graph.containsKey(cur.node)) {
                for(Info next: graph.get(cur.node)) {
                    int maxIntensity = Math.max(cur.weight, next.weight);
                    if(visited[next.node] > maxIntensity) {
                        visited[next.node] = maxIntensity;
                        pq.offer(new Info(next.node, maxIntensity));
                    }
                }
            }
            // 0    1. 2.  3.  4.  5. 6 
            // INF -1 INF -1  INF INF INF
            
        }
        
        int[] ans = {0, Integer.MAX_VALUE};
        Integer[] temp = new Integer[summits.length];
        for(int i = 0; i < summits.length; i++) {
            temp[i] = summits[i];
        }
            
        Arrays.sort(temp, Collections.reverseOrder());
        
        for(int summit: temp) {
            int minWeight = ans[1];
            if(minWeight >= visited[summit]) {
                ans[0] = summit;
                ans[1] = visited[summit];
            }
        }
        
        return ans;
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