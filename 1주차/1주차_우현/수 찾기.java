import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<m; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = array.length -1;

            while(start <= end) {
                int mid_index = (start+end)/2;
                int mid_value = array[mid_index];
                if(mid_value>target) {
                    end = mid_index-1;
                } else if(mid_value<target) {
                    start = mid_index+1;
                } else {
                    find = true;
                    break;
                }
            }
            if(find)System.out.println(1);
            else System.out.println(0);
        }



    }
}