import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int countlow(int a[]){
        int l = a[0];
        int c = 0;
        for(int i = 1;i < a.length;i++){
            if(a[i] < l){
                l = a[i];
                c++;
            }
        }
        return c;
    }
    static int counthigh(int a[]){
        int h = a[0];
        int c = 0;
        for(int i = 1;i < a.length;i++){
            if(a[i] > h){
                h = a[i];
                c++;
            }
        }
        return c;
    }
    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int highest = counthigh(scores);
        int lowest = countlow(scores);
        int br[] = new int[2];
        br[0] = highest;
        br[1] = lowest;
        return br;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
