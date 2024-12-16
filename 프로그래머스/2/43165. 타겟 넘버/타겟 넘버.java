import java.util.*;
class Solution {
    static int ans = 0;
    
    public int solution(int[] numbers, int target) {
        bfs(numbers, target,0);
        return ans;
    }
    public static void bfs(int[] numbers, int target, int step) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);

        // q에 합에대한게 담겨.
        for(int num: numbers) {
            int size = q.size();
            for(int i= 0; i< size; i++) {
                int sum = q.poll();
                q.offer(sum + num); // 0 + 4 -> 4 + 1
                q.offer(sum - num); // 0 - 4 -> 4 - 1 
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == target) {
                ans++;
            }
        }
    }
}