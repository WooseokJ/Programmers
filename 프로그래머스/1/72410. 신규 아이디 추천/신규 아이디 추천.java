import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder ans = new StringBuilder();
        
        // 1단계 대 -> 소 
        ans.append(new_id.toLowerCase());

        // 2단계 소문자, 숫자, - , _ , . 제외 모든문자 제거.
        for(int i = 0; i < ans.length(); i++) {
            char word = ans.charAt(i);
            // 소문자 혹은 숫자 
            if(Character.isLowerCase(word) || Character.isDigit(word)) continue;
            if(word == '-' || word == '_' || word == '.' )  continue;           
            ans.deleteCharAt(i);
            i--;
        }
        
        // 3단계  .. 가 연속이면 . 로 
        while(ans.indexOf("..") != -1) {
            int idx = ans.indexOf("..");
            ans.replace(idx, idx+2, ".");
        }
        
        // 4단계 .가 처음이나 끝이면 제거 .
        if(ans.charAt(0) == '.' && ans.length() > 0) {
          ans.deleteCharAt(0);  
        } 
        
        // 이거로는 오류 
        // if(ans.charAt(ans.length() -1) == '.' && ans.length() > 0) {
            // ans.deleteCharAt(ans.length()-1);  
        // }
        
        // 이거로는 풀려 
        if(ans.length() > 0 && ans.charAt(ans.length() -1) == '.') {
            ans.deleteCharAt(ans.length()-1);
        }

        // 5단계 빈문자열은 "a"로 대입
        if(ans.length() == 0) ans.append("a");
        // 6단계 16글자 이상이면 15문자 제외 나머지 뒤에 제거 , 만약 제거후 . 가 끝에 위치하면 . 제거.
        while(ans.length() >= 16) {
            ans.replace(15, ans.length(), "");
                   
            if(ans.charAt(ans.length()-1) == '.' )
                ans.deleteCharAt(ans.length()-1);
        }
            
     
        
        
        
        // 7단계 : 2자 이하면 글자길이 3 될떄까지 반복
        while(ans.length() > 0 && ans.length() <= 2) {
            char addWord = ans.charAt(ans.length()-1);
            ans.append(addWord);
        }
        
        
        
            
        
        return ans.toString();
        
        
        
    }
}