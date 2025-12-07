import java.math.BigInteger;
import java.nio.file.Files;
import java.util.*;
import java.io.*;
public class daysix {
    public static void main(String[] args) {
      System.out.println(solve("input.txt"));
      System.out.println(solve2("input.txt"));
    }

    public static long solve(String filename) {
long grandtotal = 0;
      try {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
      //CODE THAT SCANS THE FILE.
      ArrayList<Long> x = new ArrayList<Long>();
      int i = 0;
      while(sc.hasNextLong()) {
        x.add(sc.nextLong());
        i++;
  }
  int k = x.size();
  long[] first1 = new long[k/4];
  long[] first2 = new long[k/4];
  long[] first3 = new long[k/4];
  long[] first4 = new long[k/4];
  for(int ii = 0; ii < k/4; ii++) {
    first1[ii] = x.get(0+ii);
    first2[ii] = x.get(k/4+ii);
    first3[ii] = x.get(2*k/4+ii);
    first4[ii] = x.get(3*k/4+ii);
  }
  for(int ii = 0; ii < k/4; ii++) {
    String xx = sc.next();
    if(xx.charAt(0)=='+') {
        grandtotal += (first1[ii]+first2[ii]+first3[ii]+first4[ii]);
    }
    else if(xx.charAt(0)=='*') {
        grandtotal += (first1[ii]*first2[ii]*first3[ii]*first4[ii]);
    }
  }

      sc.close();//releases the file from your program
    return grandtotal;
    } catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return -1; //you can return from a void function just don't put a value.
    }

}

public static long solve2(String filename) {
        long grandtotal = 0;
    
        try {
            List<String> lines = Files.readAllLines(new File(filename).toPath());
            int H = lines.size();
            int W = lines.get(0).length();
            boolean[] sep = new boolean[W];
            for (int c = 0; c < W; c++) {
                boolean allSpace = true;
                for (int r = 0; r < H - 1; r++) {
                if (lines.get(r).charAt(c) != ' ') {
                    allSpace = false;
                        break;
                }
                }
                sep[c] = allSpace;
            }
    
            // detect problem blocks
            List<int[]> blocks = new ArrayList<>();
            int c = 0;
            while (c < W) {
                if (sep[c]) { c++; continue; }
                int start = c;
                while (c < W && !sep[c]) c++;
                int end = c; // excl
                blocks.add(new int[]{start, end});
            }
    
            for (int p = blocks.size() - 1; p >= 0; p--) {
                int start = blocks.get(p)[0];
                int end = blocks.get(p)[1];
    
                List<Long> nums = new ArrayList<>();
                for (int col = start; col < end; col++) {
                    long num = 0;
                    for (int row = 0; row < H - 1; row++) {
                        char ch = lines.get(row).charAt(col);
                        if (ch != ' ')  {
                            num *=10; num +=(ch-'0');
                         }
                    }
                    nums.add(num);
                }
    
                char op = lines.get(H - 1).charAt(start);
                long val = 1;
                if (op == '+') { 
                    val = 0;
                }
                for (long n : nums) {
                    if (op == '+') {
                        val += n;
                    }
                    else val *= n;
                }
    
                grandtotal += val;
            }
    
            return grandtotal;
    
        } catch (IOException ex) {
            System.out.println("File not found");
            return -1;
        }
    }
    
}