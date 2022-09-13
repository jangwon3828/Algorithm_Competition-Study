import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
            //compare 재정의
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs)
                return o1 >o2 ? 1: -1;
            return first_abs - second_abs;  //첫번째 값이 크면 양수, 두번째 값이 크면 음수이다. (compare는 양수,음수로 비교를 함)
        });

        for (int i=0; i<N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(MyQueue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(MyQueue.poll());
            } else {
                MyQueue.add(request);
            }
        }
    }
}