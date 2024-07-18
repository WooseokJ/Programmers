import java.util.*;


class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int ans = 0;
        long[] q1sum = {0};
        long[] q2sum = {0};
        Deque<Integer> q1 = initQueue(queue1, q1sum);
        Deque<Integer> q2 = initQueue(queue2, q2sum);
        
        long sum = q1sum[0] + q2sum[0];
        
        
        if( sum % 2 != 0 || sum == 0) {
            return -1;
        }
        
        int limit = 4 * (q1.size() + q2.size());
        
        
        while(ans < limit) {
            
            if(q1sum[0] > q2sum[0]) {
                Integer get = q1.poll();
                q2.offer(get);
                q1sum[0]-=get;
                q2sum[0]+=get;
                ans++;
            } else if(q1sum[0] < q2sum[0]){
                Integer get = q2.poll();
                q1.offer(get);
                q1sum[0]+=get;
                q2sum[0]-=get;
                ans++;
            } else {
                return ans;
            }
            
            
        }

        
        return -1;
    }
    
    public static Deque<Integer> initQueue(int[] queue1, long[] sum) {
        Deque<Integer> temp = new ArrayDeque<>();
        for(int a: queue1) {
            sum[0] += a;
            temp.offer(a);
        }
        return temp;
    }
}