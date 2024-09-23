import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1,'L');
        map.put(4,'L');
        map.put(7,'L');
        map.put(3,'R');
        map.put(6,'R');
        map.put(9,'R');
    
        Map<Integer, List<Integer>> point = new HashMap<>();
        point.put(1, new ArrayList<>(Arrays.asList(0,0)));
        point.put(2, new ArrayList<>(Arrays.asList(0,1)));
        point.put(3, new ArrayList<>(Arrays.asList(0,2)));
        point.put(4, new ArrayList<>(Arrays.asList(1,0)));
        point.put(5, new ArrayList<>(Arrays.asList(1,1)));
        point.put(6, new ArrayList<>(Arrays.asList(1,2)));
        point.put(7, new ArrayList<>(Arrays.asList(2,0)));
        point.put(8, new ArrayList<>(Arrays.asList(2,1)));
        point.put(9, new ArrayList<>(Arrays.asList(2,2)));
        point.put(0, new ArrayList<>(Arrays.asList(3,1)));
        
        StringBuilder ans = new StringBuilder();
        int[] leftPoint = {3,0};
        int[] rightPoint = {3,2};
        for(int num: numbers) {
            // 원소있는거 
            if(map.containsKey(num)) {
                ans.append(map.get(num));
                List<Integer> p = point.get(num);
                if(num == 1 || num == 4 || num == 7) {
                    leftPoint[0] = p.get(0);
                    leftPoint[1] = p.get(1);
                } else {
                    rightPoint[0] = p.get(0);
                    rightPoint[1] = p.get(1);
                }
            }
            
            // 원소없는거 
            if(num == 0 || num == 2 || num == 5 || num == 8) {
                 List<Integer> p = point.get(num);
                int l = (Math.abs(p.get(0) - leftPoint[0]) + Math.abs(p.get(1) - leftPoint[1]));
                int r = (Math.abs(p.get(0) - rightPoint[0]) + Math.abs(p.get(1) - rightPoint[1]));
                if(l < r) {
                    ans.append('L');
                    leftPoint[0] = p.get(0);
                    leftPoint[1] = p.get(1);
                } else if (l > r){
                    ans.append('R');
                     rightPoint[0] = p.get(0);
                    rightPoint[1] = p.get(1);
                } else { // 같은경우
                    if(hand.equals("right")) {
                        ans.append('R');
                       rightPoint[0] = p.get(0);
                    rightPoint[1] = p.get(1);
                    } else {
                        ans.append('L');
                          leftPoint[0] = p.get(0);
                    leftPoint[1] = p.get(1);
                    }
                }
            }
            System.out.println((leftPoint[0] + " " +leftPoint[1]));
           System.out.println((rightPoint[0] + " " +rightPoint[1]));
            
            
            
        }
        
        
        
        
        
        
        
        
        
        return ans.toString();
    }
        
        
        
        
}