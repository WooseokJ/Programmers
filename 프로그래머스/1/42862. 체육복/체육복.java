import java.util.*;
class Solution {
    public int solution(int n, int[] l, int[] reserve) {
        
        List<Integer> lost = new ArrayList<>();
        for(int temp: l)
            lost.add(temp);
        
        List<Integer> students = new ArrayList<>();
        for(int i =1; i<= n; i++)
            if(!lost.contains(i)) {
                students.add(i);
            }
       
       
       
        // student 7 8 9 10 
        // lost, 1 2 3 4 5 6
        // reserve 1 2 3 , 
        // 

        for(int add: reserve) {
            if(lost.contains(add)) {
                if(!students.contains(add)) {
                    students.add(add);    
                }
                continue;   
            }
            
            int pre = add-1;
            int back = add +1;
            
            // 2, 4 
            if(!students.contains(pre)) {
                if(pre != 0) {
                    students.add(pre);   
                }
                
            } else if(!students.contains(back)) {
                if(back != n+1) {
                    students.add(back);   
                }   
            }
        }
        
        
        return students.size();
        

    }
}



// 1 -> 2,0
// 3 -> 4,2
// 5-> 4,6

