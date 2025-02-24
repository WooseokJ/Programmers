import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n= Integer.parseInt(br.readLine());
		
		List<Long[]> arr = new ArrayList<>();
		
		for(int i=0;i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			Long start = Long.parseLong(token.nextToken());
			Long during = Long.parseLong(token.nextToken());
			arr.add(new Long[]{start, during});
		}
		
		Long ans = 0L;
		for(int i=0;i < n; i++) {
			Long[] t = arr.get(i);
			Long start = t[0];
			Long during = t[1];
			if(i ==0) {
				ans += start + during;
				System.out.println(ans);
			} else {
				if(ans >= start) {
					ans += during;
					System.out.println(ans);
				} else {
					ans = during + start;
					System.out.println(ans);
					
				}
				
				
			}
			
			
			
		}
		
	}
	
}

// 2
// 3 + 3
// 