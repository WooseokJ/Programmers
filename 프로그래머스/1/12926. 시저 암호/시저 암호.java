class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        
        for(int i= 0; i < s.length() ;i ++) {
            char word = s.charAt(i);
            if(word == ' ') {
                sb.append(word);
                continue;
            }

            if('a' <= word  && word <= 'z') { // 소문자. 
                if(word + n > 'z') {
                    word-=26;
                }
                
            } else { // 대문자.
                if(word + n > 'Z') {
                    word-=26;
                }
            }
            
            word+=n;
            
//             if('A' <= word + n  && word + n <= 'Z'){
//                 word += n;    
//             } else if('a' <= word + n && word + n <= 'z') {
//                 word +=n;
//             } else if('a' > word + n || word + n > 'z') {
//                 word-=26;
//                 word+=n;
//             } else if('A' > word + n || word + n > 'A') {
//                 word-=26;
//                 word+=n;
//             }  
            
            
            sb.append(word);
            
        }
        
        
        return sb.toString();
    }
}