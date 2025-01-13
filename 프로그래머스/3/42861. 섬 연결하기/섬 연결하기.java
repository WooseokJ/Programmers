import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int ans = 0;
        
        Map<Integer, List<A>> map = new HashMap<>();
        Queue<Integer[]> pq = new PriorityQueue<>((o1,o2) -> {
            return o1[1]-o2[1];
        });
        for(int[] cost: costs){
            map.putIfAbsent(cost[0], new ArrayList<>());
            map.putIfAbsent(cost[1], new ArrayList<>());
            map.get(cost[0]).add(new A(cost[1], cost[2]));
            map.get(cost[1]).add(new A(cost[0], cost[2]));
        }
        boolean[]visited = new boolean[n];
        
        pq.add(new Integer[]{0,0});
        while(!pq.isEmpty()) {
            Integer[] cur = pq.poll();
            int curNode = cur[0];
            int weight = cur[1];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            ans+=weight;
            if(map.containsKey(curNode)) {
                List<A> a = map.get(curNode);
                for(A b: a) {
                   if(!visited[b.nextNode]) {
                    pq.add(new Integer[]{b.nextNode, b.weight});
                    }
                }
             
            }
            
            
            
        }
        
        return ans;
    }
    public static class A {
        int nextNode, weight;
        A(int n, int w) {
            this.nextNode = n;
            this.weight = w;
        }
    }
}