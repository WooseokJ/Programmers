import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] ans = {0,0};
        
   
        
        List<List<String>> memo = new ArrayList<>();
        // 0 1 2 
        // [[] [] []]
        
        for(int i = 0; i < n; i++) {
            memo.add(new ArrayList<>());
        }
        boolean flag = true;
        outer: for(int i =0; i < words.length; i++) {
            int nPerson = (i % n);
            int prePerson = (i % n) -1;
            
            if(prePerson < 0) {
                prePerson = n-1;
            }
            

            String str = words[i];
            Character keyword = str.charAt(0);
            int len = memo.get(prePerson).size();
            
            if(!memo.get(prePerson).isEmpty()) {
                String key = memo.get(prePerson).get(len-1);
                Character preKeyword = key.charAt(key.length()-1);
                
                if(preKeyword != keyword) {
                    ans[0] = nPerson + 1;
                    ans[1] = i / n +1;
                    return ans;
                }
            }
            
            
            // 같은글자 보이면 삭제 
            for(int j = 0; j < n ;j ++) {
                List<String> ls = memo.get(j);
                if(ls.contains(str)) {
                    ans[0] = nPerson + 1;
                    ans[1] = i / n + 1;
                    return ans;
                }
                    
            }
            



      
            
            if(!memo.get(nPerson).contains(str)) {
                memo.get(nPerson).add(str);    
            }
            
            
        
            
            // System.out.println(memo);
            
            
        }
    
        if(flag) {
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        }
        
        

        return ans;
    }
    
    
}


// hello, even, not draw
// one never world