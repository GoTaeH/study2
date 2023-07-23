import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week2_9461 {
    static long[] s = new long[101];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        P();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            sb.append(s[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }

    public static void P() {
        s[1] = 1;
        s[2] = 1;
        s[3] = 1;

        for(int i = 4; i <= 100; i++) {
            s[i] = s[i-2] + s[i-3];
        }
    }
}