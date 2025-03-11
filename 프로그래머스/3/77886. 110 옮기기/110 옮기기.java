import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] ans = new String[s.length];
        
//         for(int i=0;i < s.length; i++) {
//             StringBuilder sb = new StringBuilder();
            
//             String str = s[i];
//             int idx = str.indexOf("110");
//             sb.append(str.substring(0, idx));
//             sb.append(str.substring(idx+3, str.length()));
//             System.out.println(sb.toString());
            

           
//             int insertIdx2 = sb.indexOf("110");    
//             System.out.println(insertIdx2);
//             if(sb.charAt(0) == '0') {
//                 sb.insert(1,"110");
//             }
//             else if(insertIdx2 != -1) {
//                 sb.insert(insertIdx2,"110");
//             }
//             System.out.println(sb.toString());
//             System.out.println();
//         }
        
        
        for(int a=0;a < s.length; a++) {
            String str = s[a];
            StringBuilder sb = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            
            for(int i =0;i < str.length(); i++) {
                Character c = str.charAt(i);
                int n = sb.length();
                
                if(sb.length() >= 2 && 
                  sb.charAt(n-2) == '1' &&
                      sb.charAt(n-1) == '1' && 
                      c == '0') {
                        temp.append("110");
                        sb.delete(n-2, n);
                } else {
                    sb.append(c);
                }                
            }
            // System.out.println(sb.toString() + " " +temp);
            
            if(temp.length() >0) {
                // 다 1이면 맨앞에 넣어줌. 
                if(sb.indexOf("0") == -1)
                    sb.insert(0,temp);
                else { // 그게 아니면 
                    int idx = sb.lastIndexOf("0");
                    sb.insert(idx+1, temp);
                }
            }
            // System.out.println(sb.toString());
            // System.out.println();
            ans[a] = sb.toString();
        }
        
        
        
        return ans;
    }
}

// 사전순 가장 앞에 오는 문자열
