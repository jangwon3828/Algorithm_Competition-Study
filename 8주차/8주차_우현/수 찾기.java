import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = A.length-1;
            while (start <= end) {
                int midi = (start+end)/2;
                int midv = A[midi];

                if(midv>target) {
                    end = midi-1;
                } else if(midv<target) {
                    start = midi+1;
                } else {
                    find=true;
                    break;
                }
            }
            if(find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }


        }
    }
}