import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for(int i =0;i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                idx = 0;
                sb.append(c);
                continue;
            }
            
            if(idx % 2 == 0) {
                sb.append(String.valueOf(c).toUpperCase());
            } else {
                sb.append(String.valueOf(c).toLowerCase());
                
            }
            idx++;
            
        }
        
        
        
        // StringTokenizer token = new StringTokenizer(s, " ");
        // while(token.hasMoreTokens()) {
        //     String str = token.nextToken();
        //     System.out.println(str + "" + "!");
        //     // System.out.println(str.toUpperCase());
        //     int cnt = 0;
        //     for(int i=0; i<str.length();i++) {
        //         char c = str.charAt(i);
        //         // System.out.println(c + " " + "!");
        //         if(c == ' ') {
        //             cnt++;
        //         } else if(i %2 == 0) {
        //             sb.append(String.valueOf(c).toUpperCase());
        //         } else {
        //             sb.append(String.valueOf(c).toLowerCase());
        //         }
        //     }
        //     for(int i =0; i<= cnt; i++)
        //         sb.append(" ");
        // }
        // System.out.println(sb.toString());
        
        
        return sb.toString();
    }
}