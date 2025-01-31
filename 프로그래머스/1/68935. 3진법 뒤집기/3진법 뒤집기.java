class Solution {
    public int solution(int n) {
        
        StringBuilder ans = new StringBuilder();
        
        while(n != 0) {
            ans.append(n%3);
            n/=3;
        }
        System.out.println(ans.toString());
        int a = 0;
        // int k = Integer.parseInt(ans.toString());
        for(int i=0; i< ans.length();i++) {
            int q = Integer.parseInt(String.valueOf(ans.charAt(i)));
            if(q != 0 ) {
                // System.out.println(q + " " + Math.pow(3, ans.length() - i) +" " + i);
                a+=q * Math.pow(3,ans.length() - i -1);

            }
        }
        
        
        return a;
    }
}