import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        
        List<String> arr = new ArrayList<>();
        for(String str: strings) {
            char c = str.charAt(n);
            arr.add(String.valueOf(c) + str);
        }
        Collections.sort(arr);
        
        String[] ans = new String[arr.size()];
        for(int i= 0; i < arr.size(); i++) {
            String str = arr.get(i);
            ans[i] = str.substring(1,str.length());
        }
        
        return ans;
    }
}