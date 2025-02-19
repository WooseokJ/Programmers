import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token= new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i < m; i++) {
			int q = Integer.parseInt(br.readLine());
			arr.add(q);
		}
		
		Set<Integer> set =new HashSet();
		for(int i=1;i<=n;i++)
			set.add(i);
		
		int ans =0;
		for(Integer a: arr) {
			if(set.contains(a)) {
				set.remove(a);
			}
			ans++;
			if(set.size() == 0) {
				break;
			}
			
		}
		if(set.size() != 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);			
		}
		

		
		// 1~n개 카드 
		// m장 수집 n개 모두 모으면 승리 
		
	}
}