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
            // 현재idx+1시작~ 끝까지 
            for(int i= idx+1; i < prices.length; i++) {
                ans[idx]++; // 
                // 현재가격보다 떨어진경우 -> 탈출.
                if(curPrice > prices[i]) {
                    break;
                }
            }
            idx++;
        }
        
        return ans;
    }
}
