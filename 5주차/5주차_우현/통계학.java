
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int sum = 0;

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            sum += value;
        }

        Arrays.sort(arr);

        boolean flag = false;
        int mode_max = 0;
        int mode = 10000;

        for(int i = 0; i < N; i++) {
            int jump = 0;
            int count = 1;
            int i_value = arr[i];

            for(int j = i + 1; j < N; j++){
                if(i_value != arr[j]) {
                    break;
                }
                count++;
                jump++;
            }

            if(count > mode_max) {
                mode_max = count;
                mode = i_value;
                flag = true;
            }
            else if(count == mode_max && flag == true) {
                mode = i_value;
                flag = false;
            }

            i += jump;
        }

        System.out.println((int)Math.round((double)sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(mode);
        System.out.println(arr[N - 1] - arr[0]);

    }
}