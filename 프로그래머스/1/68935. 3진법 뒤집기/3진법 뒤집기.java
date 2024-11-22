class Solution {
    public int solution(int n) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int temp = n % 3 ;
            sb.insert(0,temp);
            n /= 3;
        }
        
        // sb.insert(0, n/3);
        
        
        
        
        for(int i= 0; i < sb.length(); i++) {
            char w = sb.charAt(i);
            int a = (int) Math.pow(3,i);                
 
            if(w != '0') {

                ans += a * Integer.parseInt(String.valueOf(w));
             
            }
                

        }
        


        
        
        
        return ans;
    }
}

// 45 % 3 -> 15 , 0
//     15 %3 -> 5, 0
//     5 % 3 -> 1, 2
//     1 %3 -> 0,1
    