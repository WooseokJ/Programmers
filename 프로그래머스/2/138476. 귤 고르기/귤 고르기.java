import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Info> pq =new PriorityQueue<>();
        for(int i: tangerine) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i)+1);
            }
        }
        for(Integer key: map.keySet()) {
            int val = map.get(key);
            pq.offer(new Info(key, val));
        }
        
        // System.out.println(map);
        int cnt = 0;
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            cnt+=cur.cnt;
            ans++;
            if(cnt >= k) return ans;
            
        }
        
        
        return ans;
    }
    public static class Info implements Comparable<Info> {
        int n, cnt;
        Info(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Info o) {
      
            return o.cnt - this.cnt;

        }
    }
}


// 1: 1
// 2: 2
// 3: 2
// 4: 1
// 5: 2

// 1:1
// 2:2
// 3:2
// 4:1
// 5:2


// k개 고를려할떄 
// 1: 4
// 2: 3
// 3: 1
