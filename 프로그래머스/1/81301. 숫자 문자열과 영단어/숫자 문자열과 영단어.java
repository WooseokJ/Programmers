import java.util.*;
class Solution {
    public int solution(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        
        Set<Character> set = new HashSet<>();
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i=0; i < s.length(); i++) {
            char c=  s.charAt(i);
            if(!set.contains(c))
                temp.append(c);
            else
                ans.append(c);
            
            
            
            if(map.containsKey(temp.toString())) {
                int n = map.get(temp.toString());
                ans.append(String.valueOf(n));
                temp = new StringBuilder();
            }
            
        }
        System.out.println(ans);
        
        
        
        
        return Integer.parseInt(ans.toString());
    }
}