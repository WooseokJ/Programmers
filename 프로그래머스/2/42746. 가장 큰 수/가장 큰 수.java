import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<String> arr = new ArrayList<>();
        for(int n: numbers)
            arr.add(String.valueOf(n));
        
        Collections.sort(arr, (o1,o2) -> {return (o2+o1).compareTo(o1+o2);});
        
        if(arr.get(0).equals("0"))
            return "0";
        
        for(String s: arr)
            sb.append(s);
        

//         int temp = 0;
//         for(int num: numbers) {
//             if(num / 10 == 0 ) {
//                 temp = Math.max(temp, num);
//             }
//         }
//         pq.offer(temp);
        
//         sb.append(0);
//         int idx =0;
//         int max = 0;
//         while(!pq.isEmpty()) {
//             int cur = pq.poll();
//             int n = Integer.parseInt(sb.toString());
            
//             if(max <= n) {
//                 sb.append(cur);
//                 max = Integer.parseInt(sb.toString());
//             }
            
//             if(numbers[idx] != temp) {
//                 pq.offer(numbers[idx]);
//                 idx++;
//             } else {
//                 continue;
//             }
//             System.out.println(max);
            
            
//         }
        
        
        
        
        
        
        return sb.toString();
    }
    public static class Info implements Comparable<Info> {
        int str;
        public Info(int s) {
            this.str = s;
        }
        @Override
        public int compareTo(Info o) {
            return 1;
        } 
            
        
    }
    
}