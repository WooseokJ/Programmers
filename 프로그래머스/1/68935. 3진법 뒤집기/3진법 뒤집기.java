class Solution {
    public int solution(int n) {
        int ans = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(n != 0) {
            sb.append(n % 3);
            n /= 3;
        }
        System.out.println(sb.toString());
        
        for(int i=0; i < sb.length(); i++) {
            int k = Integer.parseInt(String.valueOf(sb.charAt(i) ));
            if(k != 0) {
                // System.out.println(Math.pow(3, sb.length() - i - 1));
                ans+= k * (Math.pow(3, sb.length() - i - 1));
            }
            
        }
        
        
        
        return ans;
    }
}