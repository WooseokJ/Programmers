class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ans =0;
        for(String str: skill_trees) {
            int cnt = 0;
            
            for(int i =0; i< str.length(); i++) {
                char curWord = str.charAt(i);
                // 현재 기술이 skill에 포함되는지
                if(skill.indexOf(curWord) != -1) {
                    // 순서대로 배웟는지 확인
                    char stand = skill.charAt(cnt);
                    if(stand == curWord) {
                        cnt++;
                    } else {
                        //순서대로 안배우면 안쪽 for문 빠져나와
                        break;
                    }
                }
                
                // 끝까지 다 간건 스킬대로 배운거니 증가
                if(i== str.length()-1) {
                    ans++;
                }
                
            }
            
            
        }
        return ans;
        
    }
}