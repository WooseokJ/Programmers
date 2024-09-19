class Solution {
    public String solution(String new_id) {
        StringBuilder ans = new StringBuilder();
        // 대-> 소
        ans.append(new_id.toLowerCase());
            
        // 소, 숫자, /  - _ . 뺴고 모두제거.
        for(int i =0; i < ans.length(); i++) {
            char word = ans.charAt(i);
            if(Character.isDigit(word) || Character.isLowerCase(word)) continue;
            if(word == '-' || word == '.' || word == '_') continue;
            ans.deleteCharAt(i);
            i--;
        }
        
        // .. -> . 
        while(ans.indexOf("..") != -1) {
            int idx = ans.indexOf("..");
            ans.replace(idx, idx+2, "."); // 1,2   w..o -> 
        }
        
        // 처음끝이 . 이면 제거 
        if(ans.length() > 0 && ans.charAt(0) == '.')
            ans.deleteCharAt(0);
        if(ans.length() > 0 && ans.charAt(ans.length()-1) == '.')
            ans.deleteCharAt(ans.length()-1);
        
        // 빈문자 -> a 대입
        while(ans.length() == 0)
            ans.append("a");
        
        // 16길이 이상이면 첫 15문자 제외한 나머지는 제거.
        if(ans.length() >= 16) {
            ans.setLength(15);
            if(ans.charAt(ans.length()-1) == '.') {
                ans.deleteCharAt(ans.length()-1);
            }
        }
        
        // ab -> abb
        while(ans.length() <= 2) {
            char addWord = ans.charAt(ans.length()-1);
            ans.append(addWord);
        }
            
        
        return ans.toString();
        
        
    }
}