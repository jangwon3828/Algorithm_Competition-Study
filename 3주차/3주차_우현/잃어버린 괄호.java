import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String example = br.readLine();

        String[] str = example.split("-");
        int result = 0;
        for(int i=0; i<str.length; i++) {
            int temp = mySum(str[i]);
            if(i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }
        System.out.println(result);
    }

    static int mySum(String s) {
        String[] str = s.split("[+]");

        int result = 0;
        for(int i=0; i<str.length; i++) {
            result += Integer.parseInt(str[i]);
        }

        return result; 
    }
}
