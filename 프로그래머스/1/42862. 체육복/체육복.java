import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int ans = n - lost.length; // 체육참석인원 = 전체 - 잃은인원
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i= 0; i < lost.length; i++) {
            for(int j =0; j < reserve.length; j++) {
                // 여벌갖은 학생이 도난된경우 -> 자기가 입어야해.
                if(lost[i] == reserve[j]) {
                    ans++; 
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
                
                
            }
        }
        
        for(int i =0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length;j++) {
                // 3 -> 4,2
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j]-1) {
                    ans++;
                    lost[i] = -1;
                    reserve[j] = -1; // 빌려줫으니 -1처리
                    
                    break;
                }
            }
        }

        
        
        return ans;
    }
}