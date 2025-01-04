import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();
        int sum = 0; 
        int time =0; 

        int curTruck = 0;
        for(int truck: truck_weights) {
            curTruck = truck;
            while(true) {
                if(q.size()== bridge_length)
                    sum-=q.poll();
                
                // 용량초과
                if(weight < curTruck+ sum ) {
                    q.add(0);
                    time++;
                } else { // 용량내면 트럭 다리위로 올라타
                    q.add(curTruck);
                    sum+=curTruck;
                    time++;
                    break;
                }
                
            }
        }
        
        
        return time + bridge_length;// 마지막트럭 빠져나옴.
    }
}