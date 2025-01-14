import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        
        
        int[][] dp = new int [triangle.length][triangle.length];
        
        for(int i=0; i< triangle.length; i++)
            if(i == 0) 
                dp[i][0] = triangle[i][0];
            else 
                dp[i][0] = triangle[i][0] + dp[i-1][0];
            
        
 
        
        
        for(int i = 1; i < triangle.length; i++) 
            for(int j = 1; j < triangle[i].length; j++) 
                dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j-1],
                                   triangle[i][j] + dp[i-1][j]);

       int ans = 0;
        for(int i = 0; i < dp.length; i++) 
            ans = Math.max(dp[dp.length-1][i], ans);
        
           
        
        
        return ans;
    }
}