import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        double l1 = 0;
        Arrays.sort(dots, (o1,o2) -> {
           return o1[0]-o2[0]; 
        });
        
        for(int i =1; i < 4; i++) {
            int x1 = dots[i][0];
            int y1 = dots[i][1];
            int x2 = dots[i-1][0];
            int y2 = dots[i-1][1];
            double l2 = (double) (y2-y1) / (x2-x1);
            if(l1 == 0) {
                l1 = l2;
                i++;
            } else if(l1 == l2) {
                return 1;
            }
            
        }
        
        return 0;
    }
}