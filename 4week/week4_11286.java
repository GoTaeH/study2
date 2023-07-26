import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class week4_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a1, Integer a2) {
                if(Math.abs(a1) > Math.abs(a2)) {
                    return Math.abs(a1) - Math.abs(a2);
                } else if (Math.abs(a1) == Math.abs(a2)) {
                    return a1 - a2;
                } else {
                    return -1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(queue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(x);
            }
        }
        System.out.println(sb);
    }
}