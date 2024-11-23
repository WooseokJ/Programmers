class Solution {
    boolean solution(String s) {
        boolean ans = true;
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p' || c == 'P') {
                pCnt++;
            } else if(c == 'y' || c == 'Y') {
                yCnt++;
            }
                
        }        
        

        if(pCnt == 0 && yCnt == 0) return true;
        
        return pCnt == yCnt;
    }
}