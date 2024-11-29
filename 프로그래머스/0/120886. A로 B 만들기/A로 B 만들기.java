import java.util.*;
class Solution {
    public int solution(String before, String after) {

        Map<Character, Integer> map = new HashMap<>();
        
        for(int i= 0; i < before.length(); i++) {
            char c =before.charAt(i);
            if(!map.containsKey(c)) {
                map.put(before.charAt(i), 1);
            } else {
                int n = map.get(c);
                map.put(c, n+1);
            }
        }
            
        Map<Character, Integer> temp = new HashMap<>();
        for(int i= 0; i < after.length(); i++) {
            char c =after.charAt(i);
            if(!temp.containsKey(c)) {
                temp.put(after.charAt(i), 1);
            } else {
                int n = temp.get(c);
                temp.put(c, n+1);
            }
        }
        
        for(Character c: map.keySet()) {
            int n = map.get(c);
            if(temp.containsKey(c)) {
                int m = temp.get(c);    
                if(n != m) return 0;
            } else {
                return 0;
            }
            
            
        }

        
        return 1;
    }
}