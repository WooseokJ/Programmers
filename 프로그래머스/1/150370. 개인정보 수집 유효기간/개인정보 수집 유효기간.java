import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> arr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String str: terms) {
            StringTokenizer st = new StringTokenizer(str, " ");
            String type = st.nextToken();
            Integer num = Integer.parseInt(st.nextToken()) * 28;
            map.put(type, num);
        }
        
        int todayDays = daysFrom2000(today);
        for(int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i], " ");
            int signDays = daysFrom2000(st.nextToken());
            int elapsedDay = todayDays - signDays;
            if(elapsedDay >= map.get(st.nextToken())) {
                arr.add(i+1);
            }
        }
        
        int[] ans = new int[arr.size()];
        for(int i =0; i < arr.size(); i++)
            ans[i] = arr.get(i);
        return ans;
    }
    
    
    public static int daysFrom2000(String date) {
        StringTokenizer st = new StringTokenizer(date, ".");
        int result = 0;
        result += (Integer.parseInt(st.nextToken()) - 2000) * 336;
        result += (Integer.parseInt(st.nextToken()) -1 ) * 28;
        result += Integer.parseInt(st.nextToken()) - 1;
        return result;
    }
}