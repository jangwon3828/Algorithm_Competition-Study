import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 집합 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = 20;
        int m = Integer.parseInt(bf.readLine());
        int s = 0;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String[] line = bf.readLine().split(" ");
            switch (line[0]) {
                case "add": {
                    int x = Integer.parseInt(line[1]) - 1;
                    s = (s | (1 << x));
                    break;
                }
                case "remove": {
                    int x = Integer.parseInt(line[1]) - 1;
                    s = (s & ~(1 << x));
                    break;
                }
                case "check": {
                    int x = Integer.parseInt(line[1]) - 1;
                    int res = (s & (1 << x));
                    if (res == 0) {
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(line[1]) - 1;
                    s = (s ^ (1 << x));
                    break;
                }
                case "all":
                    s = (1 << n) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
