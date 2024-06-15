import java.util.*;
class Solution {
    static List<Integer> arr = new ArrayList<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        
        Map<String, Integer> map = new HashMap<>();
        for(String str: terms)  {
            String[] temp = str.split(" ");
            Integer num = Integer.parseInt(temp[1]);
            map.put(temp[0], num);
        }
        
        for(int idx = 0; idx < privacies.length; idx++) {

            String[] temp = privacies[idx].split(" ");
            String date = temp[0];
            String target = temp[1];
            if(map.containsKey(target)) {
                Integer plusNum = map.get(target);
                StringTokenizer stk =new StringTokenizer(date, ".");
	            
                Integer year = Integer.parseInt(stk.nextToken());
                Integer month = Integer.parseInt(stk.nextToken());
                Integer day = Integer.parseInt(stk.nextToken());

                

                // Integer newYear = year + ((month + plusNum) / 12);
                Integer newYear = year;
                if((month + plusNum) > 12) {
                    newYear += (month + plusNum) / 12;
                    if((month + plusNum) % 12 == 0 ) {
                        newYear-=1;  
                    } 
                }
                
                
                Integer newMonth = (month + plusNum) % 12 ; 
                if(newMonth == 0) {
                    newMonth = 12;
                }
                
                
                
                StringTokenizer stk2 =new StringTokenizer(today, ".");
                Integer todayYear = Integer.parseInt(stk2.nextToken());
                Integer todayMonth = Integer.parseInt(stk2.nextToken());
                Integer todayDay = Integer.parseInt(stk2.nextToken());
                System.out.printf("%d %d %d\n", newYear, newMonth, day);
                // 오늘이 2020, 새로운게 2019이면 지나서 추가.
                if(todayYear > newYear) {
                    arr.add(idx+1);
                } else if(todayYear < newYear) { // 오늘이 2020, 새로운게  2021이면 아직남았어
                    continue;
                }
                else if(newMonth < todayMonth ){ // year는같아, month비교.
                    arr.add(idx+1);
                } else if(newMonth <= todayMonth && todayDay >= day) {
                    arr.add(idx+1);
                }
                
            }
        }
            
        
          
        
        int[] ans = new int[arr.size()];
        for(int i =0; i < arr.size(); i++)
            ans[i] = arr.get(i);
        return ans;
        
    }
}