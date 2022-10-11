import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    dq.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(dq.isEmpty() ? -1 : dq.remove()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(dq.isEmpty() ? -1 : dq.getFirst()).append("\n");
                    break;
                case "back":
                    sb.append(dq.isEmpty() ? -1 : dq.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
