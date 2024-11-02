import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int ans = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        

        // 빌려줄수있는놈이 잃어버린경우(reserve -1로 바꿔서 못빌려줘)
        for(int i =0; i < lost.length; i++) {
            for(int j =0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    reserve[j] = -1;
                    lost[i] = -1;
                    ans++;
                    break;
                }
            }
        }

        // System.out.println(ans + " " + Arrays.toString(lost) + " " + Arrays.toString(reserve) );
  
        // 3 -> 2,4번  
        // 1 -> 0, 2번.. 
        
        // 잃어버린애 빌려주기(reserve +1,-1 해서 lost일치하는지 보기.)
        for(int i= 0; i < lost.length; i++) {
            for(int j =0; j < reserve.length; j++) {
                if(lost[i] == reserve[j] + 1 || 
                    lost[i] == reserve[j] -1) {
                    
                    // lost[i] = -1;
                    reserve[j] = -1;
                    ans++;
                    
                    break;
                   
                }
            }
        }
   
        // System.out.println(ans + " " + Arrays.toString(lost) + " " + Arrays.toString(reserve) );
        
        
        
        
        
        return ans;
    }
}