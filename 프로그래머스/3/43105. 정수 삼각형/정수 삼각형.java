import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int ans = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i< triangle.length; i++)
            dp[i][0] = dp[i-1][0]+ triangle[i][0];
            
        for(int i=1; i < triangle.length; i++)
            for(int j= 1; j < triangle[i].length; j++) {
                
                dp[i][j] = Math.max(dp[i-1][j] + triangle[i][j],
                                   dp[i-1][j-1] + triangle[i][j]);
            }
                // 위+현재 , 현재 + 왼쪽위  
                
            

        
        for(int i = 0; i < triangle[triangle.length-1].length; i++) {
            ans = Math.max(ans, dp[triangle.length-1][i]);
        }
        return ans;
    }


}
// 7 0 0 0 0 
// 3 8 0 0 0
// 8 1 0 0 0
// 2 7 4 4 0
// 4 5 2 6 5
