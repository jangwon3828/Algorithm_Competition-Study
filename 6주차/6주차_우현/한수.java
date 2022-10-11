import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(function(n));

    }

    public static int function(int n) {
        int cnt = 0;
        if(n<100) {
            return n;
        }
        else {
            cnt = 99;
            for(int i=100; i<=n; i++) {
                int one = i % 10;
                int ten = (i/10)%10;
                int hun = i / 100;

                if((hun - ten) == (ten - one)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


}
