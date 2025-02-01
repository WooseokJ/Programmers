class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        // 1단계 대 -> 소
        for(int i =0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32));
            } else if(c == '-' || c == '_' || c == '.') {
                sb.append(c);
            } else if(Character.isDigit(c)) {
                sb.append(c);
            } else if( c>='a'  && c <= 'z') {
                sb.append(c);
            }
        }
        

        
        // 3단계 .. -> .
        while(sb.indexOf("..") != -1) {
            int n = sb.indexOf("..");
            sb.replace(n, n+2, ".");
        }
//         // 4단계 첫 . 제거 
        if(sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if( sb.length() != 0 && sb.charAt(sb.length()-1) == '.') {
            sb.deleteCharAt(sb.length()-1);
        }
        
//         // 5단계 빈문자열이면 a대입
        if(sb.length() == 0) {
            sb.append('a');
        }
//         // 6단계 16이상이면 

        if(sb.length() >= 16) {
            StringBuilder temp = new StringBuilder();
            temp.append(sb.substring(0,15)); 
            
            if( temp.length() != 0 && temp.charAt(temp.length()-1) == '.') {
                 temp.deleteCharAt(temp.length()-1);
            }
            
            sb.delete(0,sb.length());
            sb.append(temp);
        }
//         System.out.println(sb.toString());

        // 7단계
        while(sb.length() <= 2) {
            // System.out.println(sb.toString().charAt(sb.length()));
            sb.append(sb.toString().charAt(sb.length() - 1));
        }
    
        
        System.out.println(sb);

        
        return sb.toString();
    }
}