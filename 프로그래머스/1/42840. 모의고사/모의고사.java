import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> arr = new ArrayList<>();
        
        int[] one = new int[]  {1,2,3,4,5};
        int[] two = new int[]  {2,1,2,3,2,4,2,5};
        int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int oneSum = 0;
        int twoSum = 0;
        int thirdSum = 0;
        for(int i=0; i < answers.length; i++) {
            
            int aa = answers[i];
            
            int oneIdx = i % one.length;
            int twoIdx = i % two.length;
            int thirdIdx = i % third.length;
            // System.out.println(aa + " " + one[oneIdx] + " " + two[twoIdx] + " " +third[thirdIdx]);
            if(one[oneIdx] == aa) {
                oneSum++;
            }
            if(two[twoIdx] == aa) {
                twoSum++;
            }
            if(third[thirdIdx] == aa) {
                thirdSum++;
            }
        }
        // System.out.println(oneSum + " " + twoSum + " " + thirdSum);
        
        int max = 0;
        if(oneSum >= twoSum) {
            if(oneSum >= thirdSum) {
                max = oneSum;
            } else {
                max = thirdSum;
            }
        } else {
            if(twoSum >= thirdSum) {
                max = twoSum;
            } else {
                max = thirdSum;
            }
        }
        if(max == oneSum)
            arr.add(1);
        if(max == twoSum)
            arr.add(2);
        if(max == thirdSum)
            arr.add(3);
        
        Collections.sort(arr);
        int[] ans = new int[arr.size()];
        for(int i= 0;i < arr.size(); i++)
            ans[i] = arr.get(i);
        return ans;
    }

}
// 1 2 3 4 5
// 2 1 2 3 2 4 2 5         
// 3 3 1 1 2 2 4 4 5 5     
