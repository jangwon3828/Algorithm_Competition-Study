package baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 덱 {
    public static void main(String[] args)  {
        Scanner sc =new Scanner(System.in);
        Deque<Integer> dq = new LinkedList<>();
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            Integer a = 0;
            switch (sc.next()) {
                case "push_front":
                    dq.addFirst(sc.nextInt());
                    break;
                case "push_back":
                    dq.addLast(sc.nextInt());
                    break;
                case "pop_front":
                    a = dq.peekFirst() == null ? -1 : dq.peekFirst();
                    sb.append(a).append("\n");
                    if (a == -1) {
                        break;
                    }
                    dq.pollFirst();
                    break;
                case "pop_back":
                    a = dq.peekLast() == null ? -1 : dq.peekLast();
                    sb.append(a).append("\n");
                    if (a == -1) {
                        break;
                    }
                    dq.pollLast();
                    break;
                case "size":
                    a = dq.size();
                    sb.append(a).append("\n");
                    break;
                case "empty":
                    a = dq.peekLast() == null ? 1 : 0;
                    sb.append(a).append("\n");
                    break;
                case "front":
                    a = dq.peekFirst() == null ? -1 : dq.peekFirst();
                    sb.append(a).append("\n");
                    break;
                case "back":
                    a = dq.peekLast() == null ? -1 : dq.peekLast();
                    sb.append(a).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
