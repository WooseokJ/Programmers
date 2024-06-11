import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] ans = new int[id_list.length];
        // Create a set to ensure unique reports
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));
        
        // Report count map
        Map<String, Integer> reportCount = new HashMap<>();
        // Initialize report count map
        for (String id : id_list) {
            reportCount.put(id, 0);
        }
        
        // Reporters map
        Map<String, Set<String>> reportersMap = new HashMap<>();
        
        // Process each report
        for (String rep : uniqueReports) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            // Update report count
            reportCount.put(reported, reportCount.get(reported) + 1);
            
            // Update reporters map
            if (!reportersMap.containsKey(reporter)) {
                reportersMap.put(reporter, new HashSet<>());
            }
            reportersMap.get(reporter).add(reported);
        }
        
        // Create a set of banned users
        Set<String> bannedUsers = new HashSet<>();
        for (Map.Entry<String, Integer> entry : reportCount.entrySet()) {
            if (entry.getValue() >= k) {
                bannedUsers.add(entry.getKey());
            }
        }
        
        // Create the result array
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            if (reportersMap.containsKey(user)) {
                Set<String> reportedUsers = reportersMap.get(user);
                for (String reportedUser : reportedUsers) {
                    if (bannedUsers.contains(reportedUser)) {
                        result[i]++;
                    }
                }
            }
        }
        
        return result;
    }
}