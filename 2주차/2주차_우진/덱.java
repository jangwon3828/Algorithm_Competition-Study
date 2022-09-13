import java.util.*;
import java.io.*;

public class 덱{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();

        while(N --> 0){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push_front":   deque.offerFirst(Integer.parseInt(st.nextToken())); break;
                case "push_back":    deque.offer(Integer.parseInt(st.nextToken())); break;
                case "pop_front":
                    Integer item = deque.poll();
                    sb.append(item==null? -1 : item).append('\n');
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;
                case "size": sb.append(deque.size()).append('\n'); break;
                case "empty": sb.append(deque.isEmpty()? 1 : 0).append('\n'); break;
                case "front": sb.append(deque.isEmpty()? -1 : deque.getFirst()).append('\n'); break;
                case "back": sb.append(deque.isEmpty()? -1 : deque.getLast()).append('\n'); break;
            }
        }
        System.out.println(sb);
    }
}