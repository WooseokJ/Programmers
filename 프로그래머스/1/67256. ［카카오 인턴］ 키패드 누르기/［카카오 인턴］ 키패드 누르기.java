import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder ans = new StringBuilder();
        
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"L");
        map.put(4,"L");
        map.put(7,"L");
        map.put(3,"R");
        map.put(6,"R");
        map.put(9,"R");
        
        Map<Integer, List<Integer>> point = new HashMap<>();
        point.put(1, new ArrayList<>(Arrays.asList(0,3)));
        point.put(4, new ArrayList<>(Arrays.asList(0,2)));
        point.put(7, new ArrayList<>(Arrays.asList(0,1)));
        point.put(3, new ArrayList<>(Arrays.asList(2,3)));
        point.put(6, new ArrayList<>(Arrays.asList(2,2)));
        point.put(9, new ArrayList<>(Arrays.asList(2,1)));
        
        point.put(2, new ArrayList<>(Arrays.asList(1,3)));
        point.put(5, new ArrayList<>(Arrays.asList(1,2)));
        point.put(8, new ArrayList<>(Arrays.asList(1,1)));
        point.put(0, new ArrayList<>(Arrays.asList(1,0)));
        
        int[] l = {0,0};
        int[] r = {2,0};
        
        for(int num: numbers) {
            System.out.println(Arrays.toString(l) + " " + Arrays.toString(r));
            if(map.containsKey(num)) { //양끝 
                String str = map.get(num);
                ans.append(str);

                if(str.contains("L")) {
                    l[0] = point.get(num).get(0);
                    l[1] = point.get(num).get(1);
                } else {
                    r[0] = point.get(num).get(0);
                    r[1] = point.get(num).get(1);
                }
            } else { // 이외 숫자.

                List<Integer> pos = point.get(num);
                int x = pos.get(0);
                int y = pos.get(1);
                // System.out.println(x + " " + y);
                int n1 = Math.abs(x-l[0]) + Math.abs(y-l[1]);
                int n2 = Math.abs(x-r[0]) + Math.abs(y-r[1]);
                // System.out.println(num + " " + n1 + " " + n2);
                if(n1 > n2) { // 오른이 더 짧아 
                    ans.append("R");
                    r[0] = point.get(num).get(0);
                    r[1] = point.get(num).get(1);
                    
                } else if(n1 < n2) {
                    ans.append("L");
                     l[0] = point.get(num).get(0);
                    l[1] = point.get(num).get(1);
                } else {
                    if(hand.equals("right")) {
                        ans.append("R");
                        r[0] = point.get(num).get(0);
                        r[1] = point.get(num).get(1);
                    } else {
                        ans.append("L");
                        l[0] = point.get(num).get(0);
                        l[1] = point.get(num).get(1);
                    }
                }
                
                
            }
                    
            
        }
        
        
        return ans.toString();
    }
}