import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] person = new int[3];
        int[] one =  {1,2,3,4,5}; 
        int[] two =   {2,1,2,3,2,4,2,5}; 
        int[] thrid = {3,3,1,1,2,2,4,4,5,5}; 
        
        for(int i=0; i < answers.length; i++) {
            
            int ok = answers[i];
            int oIdx = i % one.length;
            int tIdx = i % two.length;
            int thIdx = i % thrid.length;
            
            if(ok == one[oIdx]) person[0]++;
            if(ok == two[tIdx]) person[1]++;
            if(ok == thrid[thIdx]) person[2]++;
        }
        List<Integer> temp = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        for(int i= 0; i < 3; i++) {
            max = Math.max(max, person[i]);
        }
        for(int i= 0; i < 3; i++) {
            if(max == person[i])
                temp.add(i+1);
        }
        
        
        int[] ans = new int[temp.size()];
        for(int i =0; i < temp.size(); i++)
            ans[i] = temp.get(i);
            
        return ans;
    }
}

// 3명 
// 12345 / 12345 
// 21232425 / 21232425
// 3311224455 / 33 -> 
// return 많이 맞춘사람 누군지.