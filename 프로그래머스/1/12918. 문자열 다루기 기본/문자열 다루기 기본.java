class Solution {
    public boolean solution(String s) {
        boolean ans = false;
        if((s.length() == 4 || s.length() == 6)) {
            int cnt = 0;
            for(int i=0;i < s.length(); i++) {
                char c = s.charAt(i);
                // System.out.println(Character.isDigit(c));
                if(Character.isDigit(c)) {
                    cnt++;
                }
            }
            
            
            if(cnt == s.length())
                ans = true;
        }
        
        
        return ans;
    }
}