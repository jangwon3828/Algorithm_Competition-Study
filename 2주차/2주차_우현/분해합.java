<<<<<<< HEAD
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i=0; i<N; i++) {
            int number = i;
            int sum = 0;    //각 자릿수 합

            while(number != 0) {
                sum += number %10;      //각 자릿수 더하기
                number /= 10;
            }

            if(sum+i == N){
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
=======
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i=0; i<N; i++) {
            int number = i;
            int sum = 0;    //각 자릿수 합

            while(number != 0) {
                sum += number %10;      //각 자릿수 더하기
                number /= 10;
            }

            if(sum+i == N){
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
>>>>>>> 3d310144038cc2177dad2724a9ed737a8fc365ea
}