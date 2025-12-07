import java.io.*;
import java.util.*;

public class daythree {

    static ArrayList<Long> invalid = new ArrayList<>();

    static void generateInvalid(int maxDigits) {
        for (int len = 1; len <= maxDigits; len++) {
            for (int block = 1; block <= len/2; block++) {
                if (len % block != 0) {
                    continue;
                }
                int repeats = len / block;
                if (repeats < 2) {
                    continue;
                }

                int max = (int)Math.pow(10, block);

                for (int base = 0; base < max; base++) {
                    String s = String.format("%0" + block + "d", base);

                    if (s.charAt(0) == '0') continue;

                    StringBuilder sb = new StringBuilder();
                    for (int r = 0; r < repeats; r++) {
                        sb.append(s);
                    }
                    long val = Long.parseLong(sb.toString());
                    invalid.add(val);
                }
            }
        }
        Collections.sort(invalid);
    }

    public static long solve(String filename) throws Exception {
        generateInvalid(12); //2 vs 12

        Scanner sc = new Scanner(new File(filename));
        long answer = 0;

        while (sc.hasNextLong()) {
            long lo = sc.nextLong();
            long hi = sc.nextLong();

            int left = lowerBound(invalid, lo);
            int right = upperBound(invalid, hi)-1;

            if (left <= right) {
                for (int i = left; i <= right; i++)
                    answer += invalid.get(i);
            }
        }
        return answer;
    }

    static int lowerBound(ArrayList<Long> a, long x) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l+r)>>1;
            if (a.get(m) < x) l = m+1;
            else r = m;
        }
        return l;
    }

    static int upperBound(ArrayList<Long> a, long x) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l+r)>>1;
            if (a.get(m) <= x) l = m+1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solve("input.txt"));
    }
}
