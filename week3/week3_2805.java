import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week3_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] wood = new int[N];

        int min = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            wood[i] = Integer.parseInt(st.nextToken());

            if(max < wood[i]) {
                max = wood[i];
            }
        }
        while(min < max) {
            int middle = (min + max) / 2;
            long sum = 0;
            for (int H : wood) {
                if(H - middle > 0) {
                    sum += (H - middle);
                }
            }
            if(sum < M) {
                max = middle;
            }
            else {
                min = middle + 1;
            }
        }
        System.out.println(min -1);
    }
}