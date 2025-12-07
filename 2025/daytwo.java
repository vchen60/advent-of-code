//WORK IN PROGRESS
import java.util.*;
import java.io.*;
import java.lang.Math;
public class daytwo {
    public static void main(String[] args) {
        //manually separated commas and dashes in vscode first
        System.out.println(solveA("input.txt"));
        System.out.println(solveB("input.txt"));
    }
public static long solveA(String filename) {
    long total = 0;
      try {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        ArrayList<Long> x = new ArrayList<Long>();

        ArrayList<Long> y = new ArrayList<Long>();
        while(sc.hasNext()) {
            x.add(sc.nextLong());
            y.add(sc.nextLong());
        }
        for (int i = 0; i < x.size(); i++) {
            for (long j = x.get(i); j <= y.get(i); j++) {
        
                int digits = Long.toString(j).length();
                if (digits % 2 == 0) {
                    int half = digits / 2; 
                    long pow = (long) Math.pow(10, half);
        
                    if ((j / pow) == (j % pow)) {
                        total += j;
                    }
                }
            }
        }
      sc.close();//releases the file from your program
    return total;
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      return -1;
    }
}

public static long solveB(String filename) {
    long total = 0;
      try {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        ArrayList<Long> x = new ArrayList<Long>();

        ArrayList<Long> y = new ArrayList<Long>();
        while(sc.hasNext()) {
            x.add(sc.nextLong());
            y.add(sc.nextLong());
        }
        for (int i = 0; i < x.size(); i++) {
            for (long j = x.get(i); j <= y.get(i); j++) {
                int digits = Long.toString(j).length();
                for (int k = 1; k <= digits / 2; k++) {
                    if (digits % k == 0) {
                        long pow = (long)Math.pow(10, k);
                        long chunk = j % pow;
                        long n = j;
                        boolean ok = true;
                        while (n > 0) {
                            if (n % pow != chunk) { 
                            ok = false;
                            break; 
                        }
                            n /= pow;
                        }
                        if (ok) { total += j; break; }
                    }
                }
                
            }
        }
      sc.close();//releases the file from your program
    return total;
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      return -1;
    }
}
}