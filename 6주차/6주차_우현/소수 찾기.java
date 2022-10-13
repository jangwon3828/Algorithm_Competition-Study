import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(st.nextToken());
            boolean isPrime = true;

            if(k == 1)
                continue;
            for(int j=2; j<=Math.sqrt(k); j++) {     //제곱근 까지
                if(k%j==0) {
                    isPrime = false;
                }
            }
            if(isPrime) {
                count++;
            }
        }

        System.out.println(count);


    }

}