import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] ans = {0,0};
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6,1);
        map.put(5,2);
        map.put(4,3);
        map.put(3,4);
        map.put(2,5);
        map.put(1,6);
        map.put(0,6);
        for(int i: win_nums)
            set.add(i);
        int total = 0;
        int zeroCnt = 0;
        for(int i=0;i < lottos.length; i++) {
            int num = lottos[i];
            if(num == 0) {
                zeroCnt++;
            } else {
                if(set.contains(num)) {
                  total++;  
                } 
            }
        }
        
        // 토탈+0최대개수
        ans[0] = map.get(total + zeroCnt) ;
        
        System.out.println(total + " " + zeroCnt);
        // 토탈 + 0다 안맞아
        ans[1] = map.get(total);
        
        
        return ans;
    }
}