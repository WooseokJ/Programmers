import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        
        for(String str: skill_trees) {
            StringBuilder sb = new StringBuilder();
            
            for(int i= 0; i < str.length(); i++) {
                String c = String.valueOf(str.charAt(i));
                if(skill.contains(c))
                    sb.append(c);
            }
            
            if(skill.indexOf(sb.toString()) == 0)
                ans++;
        }
        
        
        return ans;
    }
}