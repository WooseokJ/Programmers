class Solution {
    static int rowLen;
    static int colLen;
    public int[] solution(String[] keyinput, int[] board) {
        int[] ans = {0,0};
        rowLen =  board[1] / 2;
        colLen =board[0] / 2;    
        // System.out.println(rowLen + " " + colLen);
        for(String key: keyinput) {
            // System.out.println(ans[0] + " " + ans[1]);
            
            if(key.equals("up") && yValid(ans[1]+1)) {
                ans[1] +=1;
            } else if(key.equals("down") && yValid(ans[1]-1)) {
                ans[1] -=1;
            } else if(key.equals("left") && xValid(ans[0]-1)) {
                ans[0] -=1;
            } else if(key.equals("right") && xValid(ans[0]+1)){ 
                ans[0]+=1;
            }
            
            
        }
   
        // System.out.println(ans[0] + " " + ans[1]);
        
        return ans;
    }
    public static boolean xValid(int x) {
        return ( x <= colLen  && x >= -colLen ) ;
    }
    public static boolean yValid(int y) {
        return ( y <= rowLen && y >= -rowLen );
    }
    
}
// 0
// 0 
// 0 
// 0