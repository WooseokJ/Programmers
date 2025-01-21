import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int ans = 0;
        List<Integer> arr = new ArrayList<>();
        for(int c: citations)
            arr.add(c);
        
        Collections.sort(arr);
        
        for(int h= 1; h<= arr.size(); h++) {
            
            int cnt = 0;
            for(int j= 0; j < arr.size(); j++) 
                if(h <= arr.get(j)) 
                    cnt++;    
            
            if(h <= cnt)
                ans=h;
            else
                break;
            
        }
        return ans;
    }
}


// n = citations.length
// h=1일떄 인용된 논문은 1번이상인용된 논문이 1편이상 [6,5,4,1]   길이(4) >= 1
// h=2일떄 2번이상 인용된 논문이 2편이상 [6,5,3]  길이(3) >= 2
// h=3일떄 3편이상 인용된 논문이 3편이상. [6,5,3] 길이(3) >= 3
// h=4일떄 4편이상 [6,5] 길이(2) < 4 -> 조건불만족 
// 