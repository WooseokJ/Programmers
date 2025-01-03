import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int t: prices)
            q.offer(t);
        
        
        while(!q.isEmpty()) {
            int curPrice = q.poll();
            int start = (prices.length-1) - q.size();
            for(int i = start+1; i < prices.length; i++) {
                ans[start]++;
                // 가격 떨궈져
                if(curPrice > prices[i])
                    break;
            }
        }
        
        
        
        return ans;
    }
}