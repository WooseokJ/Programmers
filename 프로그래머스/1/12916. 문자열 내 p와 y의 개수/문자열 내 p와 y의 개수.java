class Solution {
    boolean solution(String s) {
        int pcnt = 0;
        int ycnt = 0;
        
        boolean ans = true;
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p' || c == 'P') {
                pcnt++;
            }else if(c == 'y' || c=='Y') {
                ycnt++;
            }
        }
        
        if(pcnt != ycnt)
            ans = false;
        

        return ans;
    }
}