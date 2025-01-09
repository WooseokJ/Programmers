import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] ans = {0,0};
        Queue<Integer> min = new PriorityQueue<>(); // [2,5] -> 2
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); // [5,2] -> 5

        for(String op: operations) {
            StringTokenizer token = new StringTokenizer(op, " ");
            String c = token.nextToken();
            int n = Integer.parseInt(token.nextToken());
 
            if(c.equals("I") ) {
                min.add(n);
                max.add(n);
            } else if(!max.isEmpty() && n == 1 && c.equals("D") ) { //최대값 삭제
                min.remove(max.poll());
            }else if(!min.isEmpty() && n== -1 && c.equals("D")) { // 최소값 삭제 
                max.remove(min.poll());
            } 

        }


        if(min.isEmpty() && max.isEmpty()) {
            return new int[]{0,0};
        } else {
            ans[0] = max.poll();
            ans[1] = min.poll();
            return ans;
        }
        
        
        
    }
 

}