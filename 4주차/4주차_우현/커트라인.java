import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list.get(M-1));

    }
}