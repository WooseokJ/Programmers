import java.util.*;
class Solution {
    public int solution(String s) {
        
        Map<String, Character> map = new HashMap<>();
        map.put("zero",'0');
        map.put("one",'1');
        map.put("two",'2');
        map.put("three",'3');
        map.put("four",'4');
        map.put("five",'5');
        map.put("six",'6');
        map.put("seven",'7');
        map.put("eight",'8');
        map.put("nine",'9');
        
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i= 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if(!Character.isDigit(c)) {
                temp.append(c);
            } else {
                sb.append(c);
            }
            
            if(map.containsKey(temp.toString())) {
                Character tt = map.get(temp.toString());
                sb.append(tt);
                temp = new StringBuilder();
            }
            
        }
        

        
        int ans = Integer.parseInt(sb.toString());
        
        return ans;
    }
}