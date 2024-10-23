import java.util.*;
class Solution {
    public int solution(String s) {
        int[] ans = {0};
        
        int n = s.length();
        
        for(int x =0; x < n; x++) {
            StringBuilder sb = new StringBuilder();
            for(int i = x; i < n ;i++) {
                sb.append(s.charAt(i));
            }
            
            for(int i = 0; i < x; i++) {   
                char word = s.charAt(i);    
                sb.append(word);
            }
            // System.out.println(sb);
            
            if(isValid(sb)) {
                ans[0]++;
            }
        }
        
        return ans[0];
    }
    public static boolean isValid(StringBuilder sb) {
        Deque<Character> stack = new ArrayDeque();
        
        for(int i = 0; i < sb.length(); i++) {
            char word = sb.charAt(i);
            
            if(word == '[') {
                stack.offerLast(']');
            } else if(word == '(') {
                stack.offerLast(')');
            } else if(word == '{') {
                stack.offerLast('}');
            } else {     // ], ), }
                
                if(!stack.isEmpty() && (stack.peekLast() == word)) {
                    stack.pollLast();
                } else {
                    return false;
                }
            }
        }
        
        // [ } false... 
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
      
        
        
    }
}