import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean ans = true;
        Set<String> map = new HashSet<>();
        for(String n: phone_book)
            map.add(n);
        
        for(int i= 0; i < phone_book.length; i++) {
            String num = phone_book[i];
            StringBuilder sb = new StringBuilder();
            for(int j=0; j < num.length(); j++) {
                char c = num.charAt(j);
                sb.append(c);
                // System.out.println(sb.toString());
                if(map.contains(sb.toString()) && !sb.toString().equals(num)) {
                    return false;
                } 
            }
            // System.out.println();
        }
        

        
        return ans;
    }
    
}