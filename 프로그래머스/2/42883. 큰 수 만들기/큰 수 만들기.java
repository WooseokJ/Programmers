import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int init_k = k;
        
        Deque<Character> stack = new ArrayDeque<>();
        // stack.offerFirst()           stack.offerLast()
        // stack. pollFirst()           stack.pollLast();
        
        for(int i =0; i < number.length(); i++) {
            char curNum = number.charAt(i);
            while(!stack.isEmpty()) {
                char top = stack.peekLast();
                // 스택 탑 < 현재 원소 -> 교체작업
                if(top < curNum) {
                    if(k==0) break;
                    stack.pollLast();
                    k--;
                } else 
                    break;
            }
            stack.offerLast(curNum);
            
        }
        
        
            
        StringBuilder ans = new StringBuilder();
        for(int i= 0; i < number.length() - init_k; i++) {
            ans.append(stack.pollFirst());
        }
        return ans.toString();
    }
}

// number.lengt() = n
// 1,000,000!
// k = 1,000,000 - 999,999 = 1 ! 