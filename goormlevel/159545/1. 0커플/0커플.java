import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		List<Integer> arr = new ArrayList<>();
		int idx = 0;
		while(token != null && token.hasMoreTokens()) {
			arr.add(Integer.parseInt(token.nextToken()));
			idx++;
		}
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for(int i=0;i < arr.size(); i++) {
			int q = arr.get(i);
			if(q > 0) {
				map.put(-q,q);	
			} else {
				map2.put(q, -q); // -1, -2 
			}
		}
		int ans =0;
		for(int i=0;i < arr.size(); i++) {
			int q = arr.get(i);
			if(map.containsKey(q) && map2.containsKey(-q)) { // -1 , -2
				continue;
			} else { // 4, 5
				ans+=q;
			}
		}
		System.out.println(ans);
		
	}
}