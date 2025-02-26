import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder ans = new StringBuilder();
        
        Deque<Integer> delete = new ArrayDeque<>();
        int size = n;
        
        for(String str: cmd) {
            StringTokenizer token=  new StringTokenizer(str, " ");
            char c;
            Integer step = 0;
            if(token.countTokens() == 2) {
                c = token.nextToken().charAt(0);   
                step = Integer.parseInt(token.nextToken());
            } else {
                c = token.nextToken().charAt(0);   
            }
             
             
            if(c == 'D') {
                k+= step;
            } else if(c == 'U') {
               k -= step;
            } else if( c == 'C') { // 삭제 
                delete.offer(k);
                size--;
                if(size == k) k--;
            } else if( c== 'Z' ) {//되돌리기
                if(k >= delete.pollLast()) k++;
                size++;
            }
            if(k <0) k =0;
        }
        
        ans.append("O".repeat(Math.max(0,size)));

        while(!delete.isEmpty()){
            ans.insert(delete.pollLast(), "X");
            
        }
        
        
        return ans.toString();
    }
}

// 0 무
// 1 콘
// 2 어
// 3 제
// 5 네
// 6 튜
// 7 라