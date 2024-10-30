class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        
        for(String str: skill_trees) {
            StringBuilder sb = new StringBuilder();
            for(int i =0; i < str.length(); i++) {
                Character c = str.charAt(i);
                String cc = String.valueOf(c);
                
                if(skill.contains(cc))
                    sb.append(c); // 순서있게 붙여.
            }
            
            // System.out.println(sb.toString() +" " + skill.indexOf(sb.toString()));
            
            if(skill.indexOf(sb.toString()) == 0) {
                ans ++;
            }

        }
        
        return ans;
    }
}