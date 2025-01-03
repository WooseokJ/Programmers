import java.util.*;
class Solution {
    public int solution(String s) {
        int ans = 0;
        for(int i= 0 ; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            Deque<Character> stack = new ArrayDeque<>();
            sb.append(s.substring(i,s.length())); // i~ 끝
            sb.append(s.substring(0,i)); // 0~i-1까지 
            
            boolean flag = true;
            // 새로운 거부터 순회
            for(int j = 0; j < sb.length(); j++) {
                char c = sb.charAt(j);
                if(c =='(') 
                    stack.push(')');
                 else if(c == '{')
                     stack.push('}');
                else if(c=='[') 
                    stack.push(']');
                else{ // 닫힌괄호들
                    // 비엇으면 혹은 비어있진않은데 원소가 달라.
                    if(stack.isEmpty() || (!stack.isEmpty() && stack.peek()!=c)) { 
                        flag = false;
                        break;
                    }                    
                    else { // 스택에 원소는 무조건있음
                        if(stack.peek() == c) {
                             stack.pop();
                        }
                    }
                    
                }
                
            }
            if(flag && stack.isEmpty())
                ans++;
            
            
        }
        
        return ans;
    }
}