import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i < progresses.length; i++) {
            int cnt = 1;
            while(100 > progresses[i] + (cnt) * speeds[i]) 
                cnt++;
            q.add(cnt);
        }
        // 7 3 9
        while(!q.isEmpty()) {
            Integer stand = q.poll();
            int cnt =1;
            
            while(!q.isEmpty() && q.peek() <= stand) {
                cnt++;
                q.poll();
            }
            ans.add(cnt);
        }
          
        int[] t = new int[ans.size()];
        for(int i=0; i < ans.size(); i++)
            t[i] = ans.get(i);
            
        return t;
        
    }
}