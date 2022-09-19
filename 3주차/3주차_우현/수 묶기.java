import java.util.*;
import java.io.*;

//큰 수들끼리 곱해야 결괏값이 최댓값이다.
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());    //내림 차순
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();                             //오름 차순
        int one = 0;
        int zero = 0;

        for(int i=0; i<N; i++) {
            int M = Integer.parseInt(br.readLine());
            if(M > 1) {
                plusPq.add(M);
            } else if(M == 1) {
                one++;
            } else if(M == 0) {
                zero++;
            } else {
                minusPq.add(M);
            }
        }

        int sum = 0;
        while (plusPq.size() > 1) {
            int num1 = plusPq.remove();
            int num2 = plusPq.remove();
            sum += (num1*num2);
        }

        if(!plusPq.isEmpty()) sum += plusPq.remove();


        while(minusPq.size() > 1) {
            int num1 = minusPq.remove();
            int num2 = minusPq.remove();
            sum += (num1*num2);
        }

        if(!minusPq.isEmpty()){
            if(zero == 0) {
                sum += minusPq.remove();
            }
        }

        sum += one;

        System.out.println(sum);


    }
}