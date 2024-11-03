import java.util.*;
class Solution {
    boolean solution(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        
        
        for(int i =0; i < s.length(); i++) {
            char word = s.charAt(i);
            if(word == '(') {
                stack.offerLast(')');
            } else { // )
                if(!stack.isEmpty() && stack.peekLast() == ')') {
                    stack.pollLast();
                } else {
                    return false;
                }
            }
            
        }
    
        

        return stack.isEmpty();
    }
}