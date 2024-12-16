import java.util.*;

class Solution {
    static int ans = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return ans;
    }
    public static void dfs(int[] numbers, int target, int step, int sum) {
        if(step == numbers.length) {
            if(target == sum)
                ans++;
            return;    
        }
        
        int plus = sum + numbers[step];
        int minus = sum - numbers[step];
        dfs(numbers, target, step+1, plus);
        dfs(numbers, target, step+1, minus);
            
        
        
    }
}