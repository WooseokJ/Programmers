class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        
        for(String str: skill_trees) {
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0 ; i < str.length(); i++) {
                char c = str.charAt(i);
                String temp = String.valueOf(c);
                if(skill.contains(temp)) {
                    sb.append(c);
                }
            }
            String s = sb.toString();
            if(skill.indexOf(s) == 0)
                ans++;
            
        }
        
        
        return ans;
    }
}