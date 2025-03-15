import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int ans = 0;
        Arrays.sort(B); 
        Arrays.sort(A);
        
        
        int idx = 0;
        for(int aNum: A) {
            boolean flag = false;
            for(int i=idx;i < B.length;i++) {
                if(B[i] == -1) continue;
                if(B[i] <= aNum ) {
                    idx++;
                } else {
                    idx = i;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                continue;
            }
                
                
            B[idx] = -1;
            ans++;
            
        }
        
        
        
        
        return ans;
    }
    
//     public static class Info implements Comparable<Info> {
//         int num;
//         Info(int n) {
//             this.num = n;
//         }
//         @Override
//         public int compareTo(Info o) {
//             return this.num - o.num ;
//         }
            
//     }
}

// N(A) N(B)
// 각 무작위 숫자 하나 
// 같으면 승점0 , 크면 +1

    // idx(번호): 숫자
// A배열 = [뽑은 숫자들]
    //return  최대 승점.


