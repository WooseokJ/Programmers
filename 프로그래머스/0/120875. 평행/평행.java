import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int ans = 0;
        Arrays.sort(dots, (o1,o2) -> {
            return o1[0] - o2[0];
        });
        Arrays.sort(dots, (o1,o2) -> {
            return o1[0] - o2[0];
        });
        
        double l = 0;
        for(int i=1;i < 4; i++) {
            double x1 = (double) dots[i][0];
            double y1 = (double) dots[i][1];
            double x2 = (double) dots[i-1][0];
            double y2 = (double) dots[i-1][1];
            double newL = (y2-y1) / (x2-x1);
            if(l == 0) {
                l = newL;
                i++;
            } else if(l == newL) return 1;
                
        }

        return ans;
    }

    
    
}
// 기울기: (y2-y1) / (x2-x1)