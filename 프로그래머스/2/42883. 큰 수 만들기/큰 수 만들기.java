import java.util.*;
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        int n = number.length() - k;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i =0; i< number.length(); i++) {
            char c = number.charAt(i);
            while(!stack.isEmpty() && stack.peekLast() < c && k-- > 0) {
                stack.pollLast();        
            }
            stack.offerLast(c);
        }
        
        
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(stack.pollFirst());
        }
        
        
        
  
        
        return sb.toString();
    }
}




// k: 4
// 정답: 987654 ✅
// 실제: 98765 ❌
// '1', '10'