class Solution {
    public boolean solution(String s) {
        boolean ans = true;
        int n = s.length();
        if(n == 4 || n == 6) {
            for(int i= 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!Character.isDigit(c)) { // 숫자아니면
                    return false;
                }
            }
        } else {
            return false;
        }
        
        
        return ans;
    }
}