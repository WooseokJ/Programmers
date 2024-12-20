import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        int num = n-k;
        
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            char newVal = number.charAt(i);
            
            while(!stack.isEmpty()) {
                char top = stack.peekLast();
								// stack의 원소보다 새로운 수가 더 크면
                if(top < newVal) { // 2 < 9 
                    // k == 0이면 -1이 되서 charAt(-1) = null되므로. 
                    if(k == 0) break;
                    stack.pollLast(); // pop
                    k--;
                    
                } else {
                    break;
                }
                
            }
            
            
            stack.offerLast(newVal);
            
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; i++)
            sb.append(stack.pollFirst());
        
        
        
        return sb.toString();
    }
}   