

class Solution {
    public String solution(String new_id) {
        // 1단계
        String step1 = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();

        // 2단계 
        int dotCnt = 0;
        StringBuilder temp = new StringBuilder();
        for(int i =0; i < step1.length(); i++) {
            Character keyword = step1.charAt(i);
            if(Character.isDigit(keyword)) { // 숫자면 true
                temp.append(keyword);
                continue;
            } 
            if(Character.isLowerCase(keyword)) { // 소문자면 넣기
                temp.append(keyword);
                continue;
            }
            
            if(keyword == '-') {
                temp.append(keyword);
                continue;
            } 
            if(keyword == '_') {
                temp.append(keyword);
                continue;
            } 
            if(keyword == '.') {
                temp.append(keyword);
                dotCnt++;
                continue;
            }
        }
        String step2 = temp.toString();
        System.out.println("2: "+step2);
        
        // 3단계 
        String step3 = step2;
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }
        System.out.println("3: "+step3);
        
        
         // 4단계 
        String step4 = step3;
        if(step4.charAt(0) == '.') {
            step4 =  step4.substring(1, step4.length());
        }
        
        // 왜안돼?
        // if(step4.charAt(step4.length()-1) == '.') { // 이 조건문에서 애초에  StringIndexOutOfBoundsException: String index out of range: -1 에러 
            // step4 = step4.substring(0,step4.length()-1);
        // }
        
        
        if(step4.endsWith(".")) {
            step4 = step4.substring(0,step4.length()-1);
        }
        System.out.println("4: "+step4);
        
        // 5단계 
        String step5 = step4;
        
        if(step5.isEmpty()) {
            step5 = "a";
        }
        System.out.println("5: "+step5);
        
        // 6단계
        String step6 = step5;
        if(step6.length() >= 16) {
            step6 = step6.substring(0,15);
            if(step6.charAt(step6.length() - 1) == '.') {
                step6 = step6.substring(0,step6.length() - 1);
            }
        }
        System.out.println("6: "+step6);
        
        // 7단계
        String step7 = step6;
        
        while (step7.length() < 3) {
            step7 += step7.charAt(step7.length()-1);
        }
            
        
        return step7;
    }
}


// 1: 대 -> 소
// 2: 소 num - _ . 제외 모든문자 제거.
// 3: .. -> . (.두개이상 -> 1개로)
// 4: 처음,마지막 . 있으면 제거.
// 5: "" -> "a" 대입
// 6: 16글자 이상시 -> 앞에서부터 15글자까지만(근데 만약 .으로 끝나면 .도 제거 )
// 7: 2글자 이하시 -> 마지막글자 반복해서 3글자까지 완성.
