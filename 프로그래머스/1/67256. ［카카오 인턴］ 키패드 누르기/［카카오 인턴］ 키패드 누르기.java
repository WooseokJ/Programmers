import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        // 1,3,7 / 3,6, 9 맵에넣고 L, R 판단.
        Map<Integer, Character> map = new HashMap<>();
        Map<Integer, Point> p = new HashMap<>();
        p.put(0, new Point(3,1));
        
        for(int i = 1;i < 10; i++) {
            if(i % 3 == 0) {
                map.put(i,'R');
                p.put(i, new Point(i/3 -1 , 2)); // 6 -> 1,2
                
            } else if(i % 3 == 1) {
                map.put(i,'L');
                p.put(i, new Point( i / 3 , 0 ));
            } else {
                p.put(i, new Point(i / 3, 1));
            }
        }
        
        // 손가락 위치.
        int[] left = {3,0};
        int[] right = {3,2};
        
        for(int num: numbers) {
            Point t = p.get(num);
            if(map.containsKey(num)) {
                Character c = map.get(num);
                sb.append(c);
                if(c == 'L') {
                    left[0] = t.r;
                    left[1] = t.c;
                } else if(c == 'R') {
                    right[0] = t.r;
                    right[1] = t.c;
                }
            } else { // // 2, 5 8, 0 은 손가락 위치와의 거리 계산. abs로 
                int temp1 = Math.abs(t.r - left[0]) + Math.abs(t.c - left[1]);
                int temp2 = Math.abs(t.r - right[0]) + Math.abs(t.c - right[1]);
                if(temp1 < temp2) { // 'L'
                    sb.append('L');
                    left[0] = t.r;
                    left[1] = t.c;
                } else if( temp1 > temp2){
                    sb.append('R');
                    right[0] = t.r;
                    right[1] = t.c;
                } else { // 거리 같으면 
                    if(hand.equals("left")) {
                        sb.append('L');
                        left[0] = t.r;
                        left[1] = t.c;
                    } else {
                        sb.append('R');
                        right[0] = t.r;
                        right[1] = t.c;
                    }
                }
            }
            
            
        }
        
        
        
        
        return sb.toString();
    }
    public static class Point{
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
}