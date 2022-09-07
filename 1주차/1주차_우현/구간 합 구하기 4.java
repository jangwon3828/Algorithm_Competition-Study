import java.util.*;
import java.io.*;

public class 구간 합 구하기 4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] array = new int[n+1];
        for (int i=1; i<=n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] plusArray = new int[n+1];

        for(int i=1; i<=n; i++) {
            plusArray[i] = plusArray[i-1] + array[i];
        }

        StringBuilder sb = new StringBuilder();


        for(int q=0; q<m; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int temp = plusArray[j] - plusArray[i-1];

            sb.append(temp).append("\n");
        }

        System.out.println(sb);


    }
}