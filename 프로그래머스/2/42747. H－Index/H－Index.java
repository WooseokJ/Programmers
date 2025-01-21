import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int ans = 0;
        List<Integer> arr = new ArrayList<>();
        for(int i: citations)
            arr.add(i);
        
        Collections.sort(arr);
        
        for(int i= 0; i < arr.size(); i++) {
            int h = arr.size()-i;
            int one = arr.get(i);
            if(one >= h)
                ans++;
            
            // System.out.println(one + " " + h);
        }
        
        return ans;
    }
}

// n = citations.length
// 5 4 3 2 1 
// 0 1 3 5 6 