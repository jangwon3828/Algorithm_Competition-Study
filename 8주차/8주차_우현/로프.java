import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int arr[] = new int [cnt];

        for(int i=0; i<cnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long max=0;
        for(int i=cnt-1; i>=0; i--) {
            arr[i]=arr[i]*(cnt-i);
            if(max<arr[i])max = arr[i];
        }
        System.out.println(max);
    }
}
