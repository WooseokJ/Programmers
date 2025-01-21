import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int ans = 0;
        List<Integer> arr = new ArrayList<>();
        for(int c: citations)
            arr.add(c);
        
        Collections.sort(arr);
        
        for(int i=0; i< arr.size(); i++) {
            int h = arr.size() - i;
            if(arr.get(i) >= h)
                ans++;
            
        }
        
        return ans;
    }
}


// n = citations.length
// h편논문이 h편이상. 
// citations[i] : 논문별 인용횟수 , i번이 citations[i]만큼 인용횟수 

// 1번이 0 번만큼 인용됨. 
// citations[i]>=i