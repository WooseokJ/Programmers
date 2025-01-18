import java.util.*;
class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i < before.length(); i++) {
            char c = before.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                Integer n = map.get(c);
                map.put(c, n+1);
            }
        }
        
        Map<Character, Integer> temp = new HashMap<>();
        
        for(int i= 0;i < after.length(); i++) {
            char c = after.charAt(i);
            if(!temp.containsKey(c)) {
                temp.put(c, 1);
            } else {
                Integer n = temp.get(c);
                temp.put(c,n+1);
            }
        }
        // System.out.println(map);
        // System.out.println(temp);
        
        boolean flag = false;
        for(Character c: map.keySet()) {
            int n =map.get(c);
            if(temp.containsKey(c)) {
                int m = temp.get(c);
                if(n != m) {
                    flag = true;
                    break;
                }
            } else {
                return 0;
            }
        }
        
        if(flag)
            return 0;
        
        return 1;
    }
}