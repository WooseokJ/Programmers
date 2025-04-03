import java.util.*;
class Solution {
    public int solution(int n, int[][] road, int k) {
        int ans = 0;
        
        Map<Integer, List<Info>> map =new HashMap<>();
        for(int [] r: road) {
            int start = r[0];
            int end = r[1];
            int weight = r[2];
            
            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());
            map.get(start).add(new Info(end, weight));
            map.get(end).add(new Info(start, weight));
        }
        
        Queue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(1,0));
        
        
        int INF = Integer.MAX_VALUE;
        int[] visited = new int[n+1];
        Arrays.fill(visited, INF);
        visited[1] = 0;
        
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(visited[cur.node] >= k) continue; 
            if(map.containsKey(cur.node)) {
                for(Info next: map.get(cur.node)) {
                    if(visited[next.node] > next.w + visited[cur.node]) {
                        System.out.println(cur.node+ " " + cur.w + " " + next.node +" "+ next.w + " " );    
                        visited[next.node] = next.w + visited[cur.node];
                        pq.offer(new Info(next.node, next.w));
                        System.out.println(Arrays.toString(visited));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(visited));
        for(int v: visited) {
            if(v <= k) {
                ans++;
            }
        }
        
        
        
        
        
        
        

        
        
        

        return ans;
    }
    public static class Info implements Comparable<Info>  {
        int node,w;
        Info(int node, int w) {
            this.node = node;
            this.w = w;
        }
        @Override
        public int compareTo(Info o){
            return this.w - o.w;
        }
    }
}
// 무방향 그래프

// n: 노드수
// k: 시간이하 배달 
// road 연결 정보 (s, e, w)
// return 개수 

