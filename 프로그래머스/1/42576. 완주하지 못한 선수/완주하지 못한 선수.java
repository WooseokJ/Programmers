import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        
        for(String p: participant) {
            if(!map.containsKey(p)) {
                map.put(p, 1);
            } else {
                Integer n = map.get(p);
                map.put(p, n+1);
            }
        }
      
        
        for(String c: completion)
            if(map.containsKey(c)) {
               Integer n = map.get(c); 
                map.put(c, n-1);
            }
                
        
        for(String key: map.keySet()) {
            Integer n = map.get(key);
            if(n!=0)
                sb.append(key);
        }
                
        
        
        return sb.toString();
    }
}