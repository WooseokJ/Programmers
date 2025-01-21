import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb= new StringBuilder();
        
        List<Character> arr = new ArrayList<>();
        for(int i=0; i< s.length(); i++)
            arr.add(s.charAt(i));
        
        
        Collections.sort(arr, Collections.reverseOrder());

        for(Character c: arr)
            sb.append(c);
        
        
        return sb.toString();
    }
}