import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int ans = 0;
        Map<Integer, List<Info>> map = new HashMap<>();
        for(int[] cost: costs) {
            map.putIfAbsent(cost[0], new ArrayList<>());
            map.putIfAbsent(cost[1], new ArrayList<>());
            map.get(cost[0]).add(new Info(cost[1], cost[2]));
            map.get(cost[1]).add(new Info(cost[0], cost[2]));
        }
        Queue<Info> pq = new PriorityQueue<>(); // 가중치 작은순서로 오름차순.
        pq.offer(new Info(0,0));
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            // 방문한적있으면 pass 
            if(visited[cur.node]) continue; 
            visited[cur.node] = true;
            // 가중치 낮은순서이므로 +해줌.
            ans+= cur.weight;
            
            if(map.containsKey(cur.node)) {
                for(Info i: map.get(cur.node)) {
                    int next = i.node;
                    int weight =i.weight;
                    // 가중치 낮은순서대로 차례대로 들어감.
                    pq.offer(new Info(next, weight));
                }
                    
            }
        }
        
            
        
        
        return ans;
    }


    public static class Info implements Comparable<Info>{
        int node, weight;
        Info(int n, int w) {
            node =n;
            weight =w;
        }
        @Override
        public int compareTo(Info o) {
            return this.weight - o.weight;
        }
    }
}