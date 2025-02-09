import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] grid = new int[n][n];
		int[][] score = new int[n][n];
		for(int i=0;i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j < n; j++) {
				int m = Integer.parseInt(token.nextToken());
				score[i][j] = m;
				grid[i][j] = m;
			}
		}
		
		int ans =0;
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		while(true) {
			boolean flag = false;
			for(int r=0;r < n ;r++) {
				for(int c= 0; c< n; c++) {
					if(grid[r][c] > 0) {
						int cnt = 0;
						for(int i= 0;i < 4; i++) {
							int nr = dr[i] + r;
							int nc = dc[i] + c;
							// System.out.println(r + " " + c + " " + nr + " " + nc);
							if((nr >= 0 && nr < n) && (nc >= 0 && nc < n)) {
								// System.out.println(nr + " " + nc + " " + grid[nr][nc]);
								if(grid[nr][nc] <= 0) {
									cnt++;
								}
							}
						}
						score[r][c] -= cnt;
					}
				}
			}
			
		// 	for(int[] a: grid)
		// 		System.out.println(Arrays.toString(a));
		// 	for(int[] a: score)
		// 		System.out.println(Arrays.toString(a));
		
		// 	System.out.println();
			
			for(int i=0;i < n; i++) {
				for(int j= 0; j < n; j++) {
					if(grid[i][j] > 0) {
						if(grid[i][j] + score[i][j] <= 0 ) {
								grid[i][j] = 0;	
								score[i][j] = 0;
						} else {
							grid[i][j] = score[i][j];			
						}
						flag = true;
					}
				}
			}
			
	
			if(!flag) break;
			ans++;
			
		}
		
		System.out.println(ans);
		
	}
}