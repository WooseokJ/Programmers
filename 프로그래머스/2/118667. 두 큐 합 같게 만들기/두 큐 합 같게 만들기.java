import java.util.*;
class Solution {

    public int solution(int[] queue1, int[] queue2) {
        int ans = 0;
        long[] q1Sum = new long[1];
        long[] q2Sum = new long[1];
        Deque<Integer> q1 = initQueue(queue1, q1Sum);
        Deque<Integer> q2 = initQueue(queue2, q2Sum);

        // 홀수이면 -1 반환.
        long total = (q1Sum[0] + q2Sum[0]);
        if(total % 2 == 1) {
            return -1;
        }
        
        // 순회 
        int limit = 3 * queue1.length;
        while(ans <= limit) {
             // 큰쪽의 원소 ->  작은쪽큐의 원소로 이동.
            if(q1Sum[0] > q2Sum[0]) {
                int addNum = q1.poll();
                q2.offer(addNum);
                q1Sum[0]-=addNum;
                q2Sum[0]+=addNum;
            } else if (q1Sum[0] < q2Sum[0]) {
                int addNum = q2.poll();
                q1.offer(addNum);
                q1Sum[0]+=addNum;
                q2Sum[0]-=addNum;
            } else {
                return ans;
            }
            ans++;
        }

        return -1;
    }
    
    private static Deque<Integer> initQueue(int[] queue, long[] qSum) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int num: queue) {
            q.offer(num);
            qSum[0]+=num;
        }
        return q;
    }
    
}