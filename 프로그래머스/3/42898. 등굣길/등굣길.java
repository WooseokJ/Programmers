import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;
        int[][] dp = new int[n+1][m+1];
        for(int[] p: puddles) {
            int m1 = p[0];
            int n1 = p[1];
            dp[n1][m1] = -1;
        }
        
        
        for(int i= 1; i <= n; i++) {
            for(int j =1; j <= m; j++) {
                if(dp[i][j] == -1) {
                    continue;
                }
                if(i == 1 && j == 1) {
                    dp[i][j] = 1 % mod;
                    continue;
                }
                
                
                // 위랑 왼쪽 다 -1 우물일떄 
                if(dp[i][j-1] == -1 && dp[i-1][j] == -1) {
                    dp[i][j] = -1 ;
                    continue;
                }
                if(dp[i][j-1] == -1) {
                    dp[i][j] = dp[i-1][j] % mod;
                }
                
                else if(dp[i-1][j] == -1) {
                    dp[i][j] = dp[i][j-1] % mod;  
                } 
                
                else {
                    dp[i][j] = (dp[i][j-1] % mod) + (dp[i-1][j] % mod);    
                    dp[i][j] %= mod;
                }
            }
        }
        
        // for(int[] p: dp)
        //     System.out.println(Arrays.toString(p));
        
        
        return dp[n][m] % mod;
    }
}