import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class week7_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], N);
            graph[i][i] = 0;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A][B] = 1;
            graph[B][A] = 1;
        }
        System.out.println(floyd(graph));
    }
    private static int floyd(int[][] arr) {
        int[] bacon = new int[arr.length];

        for(int M = 1; M < arr.length; M++) {
            for(int A = 1; A < arr.length; A++) {
                for(int B = 1; B < arr.length; B++) {
                    if(arr[A][B] > arr[A][M] + arr[M][B]) {
                        arr[A][B] = arr[A][M] + arr[M][B];
                    }
                }
            }
        }
        int min = 1;
        for(int i = 1; i < bacon.length; i++) {
            for(int j = 1; j < bacon.length; j++) {
                if(i != j) {
                    bacon[i] += arr[i][j];
                }
            }
            min = (bacon[i] < bacon[min]) ? i : min;
        }
        return min;
    }
}