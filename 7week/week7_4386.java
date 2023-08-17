import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import javax.imageio.plugins.tiff.ExifGPSTagSet;

public class week7_4386 {
    public static class Star {
        double x;
        double y;
        int num;
        public Star(double x, double y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double weight;
        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            if(weight < o.weight) return -1;
            return 1;
        }
    }
    public static int[] star;
    public static PriorityQueue<Edge> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Star[] stars = new Star[n];

        for(int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            stars[i] = new Star(x, y, i);
        }

        graph = new PriorityQueue<>();
        star = new int[n + 1];
        for(int i = 0; i < n; i++) {
            star[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                double temp = dist(stars[i], stars[j]);
                graph.offer(new Edge(stars[i].num, stars[j].num, temp));
            }
        }
        double result = 0;
        int cnt = 0;
        while(!graph.isEmpty()) {
            Edge edge = graph.poll();
            if(find(edge.start)!= find(edge.end)) {
                union(edge.start, edge.end);
                cnt = cnt + 1;
                result += edge.weight;
            }
            if(cnt == n) {
                break;
            }
        }
        System.out.printf("%.2f", result);
    }
    public static double dist (Star s1, Star s2) {
        return Math.sqrt(Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2));
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            star[y] = x;
        }
    }
    public static int find(int a) {
        if(a == star[a]) {
            return a;
        } else {
            return star[a] = find(star[a]);
        }
    }
}