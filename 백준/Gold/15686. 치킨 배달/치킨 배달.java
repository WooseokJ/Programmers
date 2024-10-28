
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] grid = new int[n][n];

        // 1의 좌표모음
        List<Point> oneList = new ArrayList<>();
        List<Point> temp = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for(int j= 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(token.nextToken());

                if(grid[i][j] == 1) {
                    oneList.add(new Point(i,j));
                } else if(grid[i][j] == 2) {
                    temp.add(new Point(i,j));
                }
            }
        }

        List<List<Point>> twoList = new ArrayList<>();
        backtrack(new ArrayList<>(), temp, 0,m, twoList);



        int ans = Integer.MAX_VALUE;

        for(List<Point>t : twoList) {

            int sum = 0;
            for(Point p : oneList) {
                int total = Integer.MAX_VALUE;

                for(Point p2: t) {
                    int distance = Math.abs(p.x - p2.x) + Math.abs(p2.y - p.y);
                    total = Math.min(total, distance);
                }
                sum += total;
            }

            ans = Math.min(sum, ans);

        }



        System.out.println(ans);






    }

    public static void backtrack(List<Point> curr, List<Point> twoList, int start, int k, List<List<Point>> ans) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < twoList.size(); i++) {
            curr.add(twoList.get(i));
            backtrack(curr, twoList, i+1, k, ans);
            curr.remove(curr.size()-1);
        }
    }
    public static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
