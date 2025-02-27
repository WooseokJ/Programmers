import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int ans = 0;
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> origin = new HashMap<>();
        for(int i=0;i <want.length; i++) {
            String str = want[i];
            int n = number[i];
            map.putIfAbsent(str, n);
            origin.putIfAbsent(str, n);
        }
        
        
        for(int i = 0;i <= discount.length - 10; i++) {
            for(int j = i; j < i + 10; j++) {
                String str = discount[j];
                if(!map.containsKey(str)) continue;
                map.put(str, map.get(str) -1);
            }
     
            // System.out.println(map);
            boolean flag = true;
            for(String s: map.keySet()) {
                int c = map.get(s);
                if(c != 0) {
                    flag = false;   
                    break;
                }
            }
            if(flag) {
                ans++;
            }
            
            map = new HashMap<>(origin);
            // System.out.println(map + " " + origin);
        }
        
        
        
        
        // want: 바바바 사사 쌀쌀 돼돼 냄
        // discount: 치 사사 바 쌀 사 돼 바 돼 쌀 냄  바  사  바.
        //           1  23  4  5 6  7 8  9 10 11 12 13  14
        
        return ans;
    }
}

