import java.util.*;
class Solution {
    public int[] solution(long n) {
        
        List<Character> arr = new ArrayList<>();
        for(int i=0;i <String.valueOf(n).length() ; i++) {
            arr.add(String.valueOf(n).charAt(i));
        }

        Collections.reverse(arr);


        int[] ans = new int[arr.size()];
        for(int i=0; i < arr.size(); i++) {
            ans[i] = arr.get(i) - 48;
        }
        
        
        return ans;
    }
}