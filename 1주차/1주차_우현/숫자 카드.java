import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int first = 0;
            int end = n-1;
            boolean find = false;

            int target = Integer.parseInt(st.nextToken());
            while(first<=end){
                int middle = (first+end)/2;
                if(target > a[middle]) {
                    first = middle + 1;
                } else if(target < a[middle]) {
                    end = middle - 1;
                } else {
                    find = true;
                    break;
                }
            }

            if(find)sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}