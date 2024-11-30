import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int ans = 0;
        int mod = 1000000007;
        
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 0;
        
        for(int[] p: puddles) {
            int x = p[1];
            int y = p[0];
            dp[x][y] = -100;
        }
  
        
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                
                

                if(dp[i][j] == -100) continue;
                
                if(i == 1 && j == 2)
                    dp[i][j] = 1;
                if(i == 2 && j == 1)
                    dp[i][j] = 1; 
                    
                
                // 왼쪽에 숫자 0 아니면 
                if((dp[i][j-1] != 0) && dp[i][j-1] != -100) {
                    dp[i][j] += (dp[i][j-1]) % mod;
                }
                // 위쪽에 숫자 0 아니면
                if((dp[i-1][j] != 0) && dp[i-1][j] != -100) {
                    dp[i][j] += (dp[i-1][j]) % mod;
                }
                    
            }
        }
        
//       for(int[] d : dp)
//             System.out.println(Arrays.toString(d));
        
        return dp[n][m] % mod;
    }
}
// return 최단경로 개수 % 1000_000_007