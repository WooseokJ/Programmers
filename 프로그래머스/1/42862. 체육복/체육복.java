import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int ans = 0;
        ans = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i =0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                // 여벌갖은 학생이 도난경우.
                if(lost[i] == reserve[j]) {
                    ans++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] - 1 == reserve[j] || 
                  lost[i]  +1 == reserve[j])  {
                    ans++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        
        return ans;
    }
}
//4 -> 3 5 
// n : 전체 학생
// lost: 도난 학생번호
// reserve: 여벌 체육복 갖은 학생. -> 2,4둘중하
// return: 체육듣는 최대학생. 