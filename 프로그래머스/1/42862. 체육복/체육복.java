
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int ans = 0;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for(int r: reserve)
            reserveSet.add(r);
        for(int l: lost) {
            // 빌려줄수있는놈이 잃어버리면 -> 자기가 써야해서 못빌려줘
            if(reserveSet.contains(l))
                reserveSet.remove(l);
            else
                lostSet.add(l);
        }
        // 빌려줄수있는놈이 잃어버린놈 빌려줘
        for(int r: reserveSet) { // 3
            // 2
            if(lostSet.contains(r-1)) {
                 lostSet.remove(r-1); // 빌려주므로 lostSet은 삭제   
            }
            // 4
            else if(lostSet.contains(r+1)) {
                lostSet.remove(r+1); // 마찬가지 
            }
            
        }
        
        
        
        ans = n - lostSet.size();
        return ans;
    }
}

// 4 -> 3, 5
// 