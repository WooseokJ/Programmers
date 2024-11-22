import java.util.*;
class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        
        List<Integer> temp = new ArrayList<>();
        for(int i =0; i < str.length(); i++) {
            char c = str.charAt(str.length() - 1 - i);
            
            int t = Integer.parseInt(String.valueOf(c));
            temp.add(t);
        }
        
        
        
        
        int[] ans = new int[temp.size()];
        for(int i= 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }

        
        return ans;

    }
}