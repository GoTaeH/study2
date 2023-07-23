import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class week3_10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] member = new String[N][2];

        for(int i = 0; i < N; i++) {
            member[i][0] = sc.next();
            member[i][1] = sc.next();
        }
        Arrays.sort(member, new Comparator<String[]>() {
            public int compare(String[] a1, String[] a2) {
                if(a1[0] == a2[0]) {
                    return 1;
                }
                else {
                    return Integer.parseInt(a1[0]) - Integer.parseInt(a2[0]);
                }
            }
        });
        for(int i = 0 ; i < N; i++) {
            System.out.println(member[i][0] + " " + member[i][1]);
        }
    }
}