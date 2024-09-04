import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ans = new int[id_list.length];
        
        // 중복제거 
        Set<String> distictReport = new HashSet<>(Arrays.asList(report));
        
        // 이름, 신고받은횟수 초기화과정
        Map<String, Integer> memo = new HashMap<>();
        for(String id: id_list)
            memo.put(id, 0);
        
        // 신고자, 신고자가 신고한 리스트
        Map<String, Set<String>> reportList = new HashMap<>();
        
        for(String temp: distictReport) {
            String front = temp.split(" ")[0]; // 신고자
            String back = temp.split(" ")[1]; // 신고당한자
            memo.put(back, memo.get(back) + 1); // 신고당한자 +1 \
            reportList.putIfAbsent(front, new HashSet<>());
            reportList.get(front).add(back);
        }
     
        
        Set<String> stopUser = new HashSet<>();
        for(Map.Entry<String, Integer> entry: memo.entrySet()) {
            Integer count = entry.getValue();
            if(count >= k) {
                String name = entry.getKey();
                stopUser.add(name);
            }
        }
        System.out.println(stopUser);
        
        for(int i = 0; i < id_list.length ; i++) {
            String userName = id_list[i];
            if(reportList.containsKey(userName)) {
                for(String back: reportList.get(userName)) {
                    if(stopUser.contains(back)) {
                        ans[i]++;
                    }
                }
            }
        }
        
        
        
        return ans;
        
        
        
    }
}