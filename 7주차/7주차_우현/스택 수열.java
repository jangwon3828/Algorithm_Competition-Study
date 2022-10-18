import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N];

        int idx = 0;
        int start = 0;

        while(N -- > 0) {
            int value = Integer.parseInt(br.readLine());

            if(value > start) {
                for(int i = start + 1; i <= value; i++) {
                    stack[idx] = i;
                    idx++;
                    sb.append('+').append('\n');
                }
                start = value;
            }

            else if(stack[idx - 1] != value) {
                System.out.println("NO");
                System.exit(0);	//	return 으로 대체해도 됨
            }

            idx--;
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }

}