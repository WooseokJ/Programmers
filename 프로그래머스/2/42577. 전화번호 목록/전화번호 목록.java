import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String str: phone_book)
            set.add(str);
        
        for(String num : phone_book) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < num.length(); i++) {
                char c = num.charAt(i);
                sb.append(c);
                String str = sb.toString();
                if(set.contains(str) && !num.equals(str))
                    return false;
            }
        }
        return true;
        
    }
}