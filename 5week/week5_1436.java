import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week5_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int endNum = 666;
        int cnt = 1;

        while(cnt != N) {
            endNum++;
            if(String.valueOf(endNum).contains("666")) {
                cnt++;
            }
        }
        System.out.println(endNum);
    }
}