import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 구름-Quiz1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[14];
        Map<String, Integer> value = toMap();
        for (int i = 0; i < n; i++) {
            check[value.get(sc.next())] = true;
        }

        int a = value.get(sc.next());

        while (a < 14 && check[a]) {
            a++;
            n--;
        }

        System.out.println(n);
    }

    public static Map<String, Integer> toMap(){
        Map<String, Integer> toMap = new HashMap<>();
        toMap.put("0", 0);
        toMap.put("1", 1);
        toMap.put("2", 2);
        toMap.put("3", 3);
        toMap.put("4", 4);
        toMap.put("5", 5);
        toMap.put("6", 6);
        toMap.put("7", 7);
        toMap.put("8", 8);
        toMap.put("9", 9);
        toMap.put("G", 10);
        toMap.put("R", 11);
        toMap.put("O", 12);
        toMap.put("M", 13);
        return toMap;
    }
}
