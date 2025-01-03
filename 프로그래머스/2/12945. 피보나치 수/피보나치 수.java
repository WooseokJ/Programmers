
class Solution {
    public int solution(int n) {
        int ans = 0;
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        int mod = 1234567;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        return dp[n];
    }

}