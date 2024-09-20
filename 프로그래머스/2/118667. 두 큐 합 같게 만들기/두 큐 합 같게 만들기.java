import java.util.*;

class Solution {
    

    public int solution(int[] queue1, int[] queue2) {
        int ans = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        
        for(int qa: queue1) {
            
            q1Sum += qa;
            q1.offer(qa);
        }
        for(int qa: queue2) {
            
            q2Sum += qa;
            q2.offer(qa);
        }
    

            
        
        
        long total = q1Sum + q2Sum;
        if( total % 2 == 1) return -1;
        
        while(ans <= 3 * queue1.length) {
            if(q1Sum > q2Sum) {
                
                int add = q1.poll();
                q2.offer(add);
                q1Sum-=add;
                q2Sum+=add;    
            } else if(q1Sum < q2Sum) {
                int add = q2.poll();
                q1.offer(add);
                q1Sum+=add;
                q2Sum-=add;
            } else {
                return ans;
            }
            ans++;
        }
        return -1;
        
        
        
    }
}