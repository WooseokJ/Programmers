import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        boolean[][] wall = new boolean[N+1][N+1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= N; c++) {
                wall[r][c] = (st.nextToken().equals("1"));
            }
        }

				// 택시의 초기 위치와 승객의 위치를 찾아 저장한다.
				// Passenger 클래스는 시작 위치(Point)와 목적지(Point)를 가진다.
        st = new StringTokenizer(reader.readLine());
        Point taxi = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Map<Point, Passenger> passengers = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            Point from = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point to = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            passengers.put(from, new Passenger(from, to));
        }
        // System.out.println("taxi = " + taxi);
        // System.out.println("passengers = " + passengers);

        final int[] dr = { -1,  0,  1,  0 };
        final int[] dc = {  0, -1,  0,  1 };
				// Entry 클래스는 현재 위치와 이동 거리를 가진다.
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(new Entry(taxi, 0));
        for (int i = 0; i < M; i++) {
						// 1. 태울 승객을 결정하는 단계. 태울 승객이 passenger에 저장된다.
            Passenger passenger = null;
            Point initialPoint = queue.peek().p;
						// 만약 현재 위치에 승객이 있다면 즉시 승객을 태운다.
            if (passengers.containsKey(initialPoint)) {
                passenger = passengers.get(initialPoint);
                queue.clear();
            }
						// 아니라면 BFS로 가장 가까운 승객을 탐색한다.
            int usage = 0;
            boolean[][] visited = prepareVisited(wall);
            while (!queue.isEmpty()) {
                Entry cur = queue.remove();
//                System.out.println("cur = " + cur);
                if (cur.dist == fuel) break;
								// 이미 찾은 승객이 있고, 거리가 최소 이동 거리보다 크거나 같으면 탐색을 종료한다.
                if (passenger != null && usage <= cur.dist) break;

                for (int d = 0; d < 4; d++) {
                    Point next = new Point(cur.p.r + dr[d], cur.p.c + dc[d]);
                    if (next.inRange(N, N) && !visited[next.r][next.c]) {
                        visited[next.r][next.c] = true;
												// 현재 위치에 승객이 있는지 확인한다.
                        if (passengers.containsKey(next)) {
                            Passenger newPassenger = passengers.get(next);
														// 처음 발견한 승객이라면 passenger에 저장한다.
														// 처음이 아니라면 이전 승객과 위치를 비교한다.
                            if (passenger == null) {
                                passenger = newPassenger;
                                usage += cur.dist + 1;
                            } else if (newPassenger.from.compareTo(passenger.from) < 0 && usage == cur.dist + 1) {
                                passenger = newPassenger;
                            }
                        } else {
                            queue.add(new Entry(next, cur.dist + 1));
                        }
                    }
                }
            }
						// 승객을 못 찾았다면 -1 출력.
            if (passenger == null) {
                System.out.println(-1);
                return;
            }
            fuel -= usage;
//            System.out.println("found passenger");
//            System.out.println("    passenger = " + passenger);
//            System.out.println("    usage = " + usage);
//            System.out.println("    fuel = " + fuel);
            usage = 0;
            queue.clear();
            queue.add(new Entry(passenger.from, 0));
            boolean arrived = false;
            visited = prepareVisited(wall);
						// 찾은 승객의 위치부터 목적지까지 BFS를 수행한다.
            outer: while (!queue.isEmpty()) {
                Entry cur = queue.remove();
                if (cur.dist == fuel) break;

                for (int d = 0; d < 4; d++) {
                    Point next = new Point(cur.p.r + dr[d], cur.p.c + dc[d]);
                    if (next.inRange(N, N) && !visited[next.r][next.c]) {
                        visited[next.r][next.c] = true;
                        if (passenger.to.equals(next)) {
                            arrived = true;
                            usage = cur.dist + 1;
                            break outer;
                        } else {
                            queue.add(new Entry(next, cur.dist + 1));
                        }
                    }
                }
            }

            if (arrived) {
                fuel += usage;
//                System.out.println("    deliver passenger");
//                System.out.println("        usage = " + usage);
//                System.out.println("        fuel = " + fuel);
                queue.clear();
                queue.add(new Entry(passenger.to, 0));
                passengers.remove(passenger.from);
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(fuel);
    }
		
		static boolean[][] prepareVisited(boolean[][] wall) {
        boolean[][] result = new boolean[wall.length][wall[0].length];
        for (int r = 0; r < wall.length; r++) {
            System.arraycopy(wall[r], 0, result[r], 0, result[r].length);
        }
        return result;
    }

    static class Entry {
        Point p;
        int dist;

        public Entry(Point p, int dist) {
            this.p = p;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "E" + p + ":" + dist;
        }
    }

    static class Passenger {
				// 디버깅용 필드
        static int seq = 1;
        int id;
        Point from;
        Point to;

        public Passenger(Point from, Point to) {
            this.id = seq++;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "P" + id + ":" + from + "->" + to;
        }
    }

    static class Point implements Comparable<Point> {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean inRange(int n, int m) {
            return r > 0 && r <= n && c > 0 && c <= m;
        }

        @Override
        public String toString() {
            return "(" + r + "," + c + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point)o;
                return this.r == p.r && this.c == p.c;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.r, this.c);
        }

        @Override
        public int compareTo(Point p) {
            if (this.r == p.r) {
                return this.c - p.c;
            } else {
                return this.r - p.r;
            }
        }
    }
}