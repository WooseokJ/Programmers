import java.util.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i < s.length(); i++) {
            char c = s.charAt(i);
            // 공백 무시 
            if(c == ' ') {
                sb.append(c);
                continue;
            }
            if(c >= 'a' && c <= 'z') {
                int diff = (c - 'a' + n) % 26;
                sb.append((char)('a'+ diff));   
            } else {
                int diff = (c - 'A' + n) % 26;
                sb.append((char)('A'+ diff));  
            }
            
            
   
            
            
        }
        
        
        return sb.toString();
    }
}