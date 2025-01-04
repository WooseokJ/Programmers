import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Integer> q = new ArrayDeque<>(); // 다리
        int total = 0;  
        int time = 0;
        
       for(int i= 0; i< truck_weights.length; i++) {
           int curTruck = truck_weights[i];
           while(true) {
               time++;
               //다리 최대면 다리에서 뺴줘.
               if(q.size() == bridge_length) {
                   total-=q.poll();
                   // System.out.println(q);
               }
               
               //중량초과
               if(total + curTruck > weight) {
                   q.add(0);
               } else {
                   q.add(curTruck);
                   total+=curTruck;
                   break;
               }
           }
           
       }
 
        
        return time + bridge_length;
    }
    
    
}
