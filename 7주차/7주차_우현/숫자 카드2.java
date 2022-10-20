import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();

        // 숫자 카드 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(!map.containsKey(num)) {
                map.put(num, 1);
            }
            // 이미 있는 숫자라면 +1
            else {
                map.put(num, map.get(num) + 1);
            }
        }

        // 찾을 카드 입력
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 숫자가 존재하면 갯수 리턴
            if(map.containsKey(num)) {
                sb.append(map.get(num) + " ");
            }
            // 없다면 0
            else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb.toString());
    }
}