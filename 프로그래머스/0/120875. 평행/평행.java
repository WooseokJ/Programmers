import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int ans = 0;
        Arrays.sort(dots, (o1,o2) -> {
            return o1[0] - o2[0];
        });
        
        
        double l = -1;
        for(int i =1; i < 4; i++) {
            double x1 = (double) dots[i][0];
            double y1 = (double) dots[i][1];
            double x2 = (double) dots[i-1][0];
            double y2 = (double) dots[i-1][1];
            // System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " "+ l + " " + (double)((y2-y1) / (x2-x1)));
            if(l == -1.0) {
                l = (y1-y2) / (x1-x2);
                i++;
            } else if(l == ((y1 - y2) / (x1-x2))){
                return 1;
            } 
        }
        return ans;
    }

    
    
}
// 기울기: (y2-y1) / (x2-x1)