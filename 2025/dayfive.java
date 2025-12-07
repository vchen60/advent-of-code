import java.util.*;
import java.io.*;
public class dayfive {
    public static void main(String[] args) {

      System.out.println(solveA("input.txt"));
      System.out.println(solveB("input.txt"));

    }
    public static long solveA(String filename) {
        int total = 0;
        try (Scanner sc = new Scanner(new File(filename))) {
            long[] finalNos = new long[1000];
            long[] low = new long[192];
                long[] hi = new long[192]; //size of my input
            while (sc.hasNextLong()) {
                for (int i = 0; i < 192; i++) {
                    low[i] = sc.nextLong();
                    hi[i] = sc.nextLong();
                }
                for(int i = 0; i < 1000; i++) {
                    finalNos[i]=sc.nextLong();
                }
            }
            for(int i = 0; i < 1000; i++) {
                for(int j = 0; j < 192; j++) {
                    if(finalNos[i]>low[j]&&finalNos[i]<hi[j]) {
                        total++;
                        break;
                    }
                }
            }
            return total;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static long solveB(String filename) {
    try (Scanner sc = new Scanner(new File(filename))) {

        while (sc.hasNextLong()) {

            long[] low = new long[192];
            long[] hi = new long[192];

            for (int i = 0; i < 192; i++) {
                low[i] = sc.nextLong();
                hi[i] = sc.nextLong();
            }

            List<long[]> intervals = new ArrayList<>();
            for (int i = 0; i < 192; i++) {
                intervals.add(new long[]{low[i], hi[i]});
            }
            intervals.sort(Comparator.comparingLong(a -> a[0]));

            long total = 0;
            long currL = intervals.get(0)[0];
            long currR = intervals.get(0)[1];

            for (int i = 1; i < intervals.size(); i++) {
                long L = intervals.get(i)[0];
                long R = intervals.get(i)[1];

                if (L <= currR + 1) {
                    currR = Math.max(currR, R);
                } 
                else {
                    total += currR - currL + 1;
                    currL = L;
                    currR = R;
                }
            }
            total += currR - currL + 1;

            return total;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return -1;
}

}