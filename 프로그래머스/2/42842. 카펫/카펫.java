import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = {0,0};
        int total = brown + yellow;
        
        List<Info> arr = new ArrayList<>();
        for(int i =1; i <= total ; i++) {
            if(total % i == 0) {
                int n = total / i;
                if(i >= n) {
                    arr.add(new Info(i,n));    
                } else {
                    arr.add(new Info(n,i));
                }
            }
        }    
        for(Info f: arr) {
            
            
            
            if(yellow == ((f.x-2) * (f.y-2))) {
                ans[0] = f.x;
                ans[1] = f.y;
            }

        }
        
        
        
        
        return ans;
    }
    public static class Info {
        int x, y;
        Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}
// 0 0 0 0 0
// 0 1 1 1 0 
// 0 1 1 1 0 
// 0 1 1 1 0
// 0 1 1 1 0
// 0 0 0 0 0



// brown: 10개 
// yellow: 2개
// return [가로 세로]

// 가로 >= 세로
// 12 -> 1 * 12 , 2 * 6, 3 * 4