import java.util.*;
class Solution {
    public String solution(String s) {
        
        List<Character> str = new ArrayList<>();
        for(int i= 0;i < s.length(); i++)
            str.add(s.charAt(i));
        
        
        Collections.sort(str, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(Character c: str)
            sb.append(c);
        
        
        
        return sb.toString();
        
        
    }
}