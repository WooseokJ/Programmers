import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i= 0;i <= 9; i++)
            set.add(i);
        
        for(int n: numbers)
            if(set.contains(n))
                set.remove(n);
        for(Integer n: set)
            ans+=n;
        return ans;
    }
}