import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> q = new ArrayDeque<>();
        for(int a: prices)
            q.offer(a);
        
        int idx = 0;
        while(!q.isEmpty()) {
            int curPrice = q.poll();
            int start = prices.length - q.size();
            // 현재idx+1부터 시작.
            for(int i= idx+1; i < prices.length; i++) {
                
                ans[idx]++;
                // 가격 떨어진경우
                if(curPrice > prices[i]) {
                    break;
                }
                
                
            }
            
            idx++;
            
        }
        return ans;
    }
}
