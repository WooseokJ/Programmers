import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int ans =0;
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int move: moves) {
            
            int num = pick(board, move);
            // System.out.println(num);
            if(q.isEmpty())  {
                if(num == -1) 
                    continue;
                q.offer(num);
            }
                
            // 4 3 1 1 3 2 0 4
            else {
                // System.out.println(q +  " " + num);
                if(q.peekLast() == num) {
                    // System.out.println(q);
                    q.pollLast();
                    ans+=2;
                    // System.out.println(q);
                } else {
                    q.offer(num);
                }
                
                
            }
                
                
            
            
            
            
        }
        
        
        return ans;
        
        
    }
    public static int pick(int[][] board, int move) {
        for(int i=0;i < board.length; i++) {
            if(board[i][move-1] != 0) {
                int n = board[i][move-1];
                board[i][move-1] = 0;
                return n;
            }
        }
        return -1;
    }
}



// 0 0 0 0 0
// 0 0 1 0 3
// 0 2 5 0 1
// 4 2 4 4 2
// 3 5 1 3 1


// return은 터진 인형개수 