import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        int deleteZero = 0;
        int cnt = 0;
        int t = 0;
        while(!s.equals("1")) {
        // while(t < 3){
            t++;
            List<Character> arr = new ArrayList<>();

            int zero = 0;
            for(int i=0; i < s.length(); i++) {
                char w = s.charAt(i);
                if(w == '1') {
                    arr.add(w);
                } else {
                    zero++;
                }
            }
            deleteZero+= zero;
            int c = arr.size(); // 4
            StringBuilder sb = new StringBuilder();
            int a = 0;
            while(c != 0){
                a++;
                sb.insert(0, c % 2);
                c = c / 2;
                // System.out.println(s + " " + c + " " + sb.toString());
            }
            

            s = sb.toString();
            cnt++;
                
        }
        

        
        int[] ans = new int[2];
        ans[0] = cnt;
        ans[1] = deleteZero;
        return ans;
    }
}
// return [이진변환횟수,제거된 0개수]