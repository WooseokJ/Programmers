import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int ans = 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num: numbers){
            if(!set.contains(num))
                set.add(num);
        }
        
        for(int i= 0; i< 10; i++) {
            if(!set.contains(i))
                ans+=i;
        }
        
        return ans;
    }
}