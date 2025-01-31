
class Solution {
    public int[] solution(String s) {
        int[] ans = {0,0};
        
        while(!s.equals("1")) {
            int cnt = 0;
            for(int i=0;i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    ans[1]++;
                } else {
                    cnt++;
                }
            }
            s = transform(cnt);
            ans[0]++;
        }
        return ans;
    }
    public static String transform(int cnt) {
        StringBuilder sb = new StringBuilder();
        while(cnt != 0) {
            sb.append(cnt % 2);
            cnt/=2;
        }
        return sb.toString();
        
    }
}