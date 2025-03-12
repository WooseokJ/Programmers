import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int ans = 0;
        String str = transform(n,k);
        System.out.println(str);
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i < str.length();i++) {
            char c = str.charAt(i);
            if(c == '0') {
                if(valid(sb.toString())) {
                    arr.add(sb.toString());    
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);    
            }
            // 끝일떄
            if(i == str.length()-1 && c != '0') {
                if(valid(sb.toString())) {
                    arr.add(sb.toString());    
                }
                
            }
            
        }
        for(int i=0;i < arr.size(); i++) {
            if(arr.get(i).equals("") || arr.get(i).equals("1")) continue;
            ans++;
                
            
        }
        System.out.println(arr);
        
        
        
        return ans;
    }
    // 소수판별
    public static boolean valid(String str) {
        if(str.equals("1") || str.equals("")) return false;
        int cnt =0;
        
        Long n = Long.parseLong(str);
        for(int i=2;i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    // k진법변환
    public static String transform(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n/k != 0) {
            sb.insert(0,n%k);
            n/=k;
            
        }
        sb.insert(0,n%k);
        
        return sb.toString();
        
    }
}
// n -> k진수변환시 조건맞는 소수 몇개인지?

// 소수 양쪽에 0이 있는 경우(0P0)
// P0
// 0P
// P  (p는 0포함x, 101될수 x)
    
// 437674 -> 3진수 -> 211 0 2 01010 11 (10진법으로볼떄 소수여야해 )

    
