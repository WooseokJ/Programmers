import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};
    public static int ans =0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int rowLen = Integer.parseInt(split[0]);
        int colLen = Integer.parseInt(split[1]);

        int[][] grid = new int[rowLen][colLen];

        List<Point> emptySet = new ArrayList<>();
        List<Point> wallSet = new ArrayList<>();
        List<Point> virusSet = new ArrayList<>();

        for(int r = 0; r < rowLen; r++) {
            String[] split1 = br.readLine().split(" ");
            for(int c = 0; c < colLen; c++) {
                grid[r][c] = Integer.parseInt(split1[c]);
                switch (grid[r][c]) {
                    case 0:
                        emptySet.add(new Point(r,c));
                        break;
                    case 1:
                        wallSet.add(new Point(r,c));
                        break;
                    case 2:
                        virusSet.add(new Point(r,c));
                        break;
                }
            }
        }

        List<List<Point>> wallthree = new ArrayList<>();
        combination(new ArrayList<>(), emptySet, 0, 3, wallthree);


        boolean[][] visited = new boolean[rowLen][colLen];
        for(List<Point> wall: wallthree) {
            // 벽세우기
            for (Point point : wall) {
                grid[point.r][point.c] = 1;

            }
            int[][] copy = new int[rowLen][colLen];
            for (int i = 0; i < rowLen; i++) {
                copy[i] = Arrays.copyOf(grid[i], grid[i].length);
                Arrays.fill(visited[i], false);
            }


            // 벽세우고나서 바이러스 전파.
            bfs(virusSet , visited, copy, rowLen, colLen);

            // 원상복구
            for (Point point : wall) {
                grid[point.r][point.c] = 0;
            }

        }


//        print(grid);
        System.out.println(ans);


    }
    public static void combination(List<Point> curr, List<Point> emptySet, int start, int k, List<List<Point>> ans) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < emptySet.size() ;i++) {
            curr.add(emptySet.get(i));
            combination(curr, emptySet, i+1, k, ans);
            curr.remove(curr.size() - 1);
        }
    }
    public static void bfs(List<Point> virusSet, boolean[][] visited, int[][] grid, int rowLen, int colLen) {
        Deque<Point> q = new ArrayDeque<>();
        for(Point v: virusSet) {
            q.offer(new Point(v.r, v.c));
            visited[v.r][v.c] = true;
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int curRow = cur.r;
            int curCol = cur.c;
            for(int i =0; i < 4; i++) {
                int nr = curRow + dr[i];
                int nc = curCol + dc[i];
                if( (0 <= nr && nr < rowLen) && (0 <= nc && nc < colLen) ) {
                    if((!visited[nr][nc]) && (grid[nr][nc] == 0) ) {
                        grid[nr][nc] =2;
                        q.offer(new Point(nr,nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
//        print(grid);
//        System.out.println();
        int emptycnt = emptyCnt(grid);
        ans = Math.max(ans, emptycnt);

    }
    public static int emptyCnt(int[][] grid) {
        int sum = 0;
        for(int[] g: grid) {
            for(int a: g) {
                if(a == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
    public static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void print(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }



}
