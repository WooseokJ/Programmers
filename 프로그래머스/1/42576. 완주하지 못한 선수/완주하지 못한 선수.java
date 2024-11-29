import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
        
        Map<String , Integer > map = new HashMap<>();
        for(String str: completion) {
            if(!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
                
        }

        
       for(String str: participant) {
            if(!map.containsKey(str)){
                return str;
            } else {
                Integer n = map.get(str);
                if(n == 0) {
                    return str;
                } else {
                    map.put(str,n -1);
                }
        
            }
       }

        return ans;
    }
}