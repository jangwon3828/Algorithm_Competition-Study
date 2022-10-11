import java.util.*;
import java.io.*;


public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int number, int jarisu) {
        if(jarisu == N) {
            if(isPrime(number)) {
                System.out.println(number);
            }
            return;
        }
        for (int i=1; i<10; i++) {
            if(i % 2 == 0) {        //짝수면 넘어가기
                continue;
            }
            if(isPrime(number * 10 + i)) {      //소수면 재귀 함수로 자릿수 늘리기
                DFS(number * 10 + i, jarisu + 1);
            }
        }
    }


    //소수 판별
    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++)
            if(num%i==0)
                return false;
        return true;
    }
}
