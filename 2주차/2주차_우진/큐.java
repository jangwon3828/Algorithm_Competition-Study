import java.io.*;
import java.util.*;

public class 큐{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i = Integer.parseInt(br.readLine()); i>0; i--){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            if(n.equals("push"))
                stack.add(st.nextToken());
            else if(n.equals("pop")) {
                if(stack.isEmpty()){
                    sb.append("-1").append('\n');
                }else{
                    sb.append(stack.get(0)).append('\n');
                    stack.remove(0);
                }
            }else if(n.equals("size"))
                sb.append(stack.size()).append('\n');
            else if(n.equals("empty"))
                sb.append(stack.isEmpty() == true? 1 : 0).append('\n');
            else if(n.equals("size"))
                sb.append(stack.size()).append('\n');
            else if(n.equals("front"))
                sb.append(stack.isEmpty()? -1 : stack.get(0)).append('\n');
            else if(n.equals("back"))
                sb.append(stack.isEmpty()? -1 : stack.peek()).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    }
}