import java.util.*;
import java.io.*;
public class dayseven {
    public static void main(String[] args) {

      System.out.println(solveA("input.txt"));

      System.out.println(solveB("input.txt"));

    }


    public static int solveA(String filename) {
      int total = 0;
      try {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        char[][] christmas = new char[142][141];
        
      //CODE THAT SCANS THE FILE.
      int currentstr = 0;
      while(sc.hasNext()) {
        String a = sc.nextLine();
        for(int i = 0; i < 141; i++) {
            christmas[currentstr][i]=a.charAt(i);
        }
        currentstr++;
      }
      System.out.println(Arrays.toString(christmas[4]));
      //finished reading array
      //my s is at 71
      int[] tachyon1 = new int[141];
int[] tachyon2 = new int[141];
tachyon1[70] = 1;

for (int i = 0; i < 142; i++) {
    if (i % 2 == 0) {
        for (int j = 0; j < 141; j++) {
            if (tachyon1[j] != 0) {
                if (christmas[i][j] == '^') {
                    if (j > 0) tachyon2[j-1] = 1;
                    if (j < 140) tachyon2[j+1] = 1;
                    total++;
                } else {
                    tachyon2[j] = 1; // propagate downward
                }
            }
        }
        Arrays.fill(tachyon1, 0);
    } else {
        for (int j = 0; j < 141; j++) {
            if (tachyon2[j] != 0) {
                if (christmas[i][j] == '^') {
                    if (j > 0) tachyon1[j-1] = 1;
                    if (j < 140) tachyon1[j+1] = 1;
                    total++;
                } else {
                    tachyon1[j] = 1; // propagate downward
                }
            }
        }
        Arrays.fill(tachyon2, 0);
    }
}

      return total;
  }

catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return -1; //you can return from a void function just don't put a value.
    }
  }
    


    public static long solveB(String filename) {
        long total = 0;
        try {
          File file = new File(filename);
          Scanner sc = new Scanner(file);
          char[][] christmas = new char[142][141];
          
        //CODE THAT SCANS THE FILE.
        int currentstr = 0;
        while(sc.hasNext()) {
          String a = sc.nextLine();
          for(int i = 0; i < 141; i++) {
              christmas[currentstr][i]=a.charAt(i);
          }
          currentstr++;
        }
        System.out.println(Arrays.toString(christmas[4]));
        //finished reading array
        //my s is at 71
  long[] current = new long[141];
  current[70] = 1; // starting S
  for (int i = 0; i < 142; i++) {
      long[] next = new long[141];
      for (int j = 0; j < 141; j++) {
          if (current[j] == 0) {
            continue;
          }
          if (christmas[i][j] == '^') {
              if (j > 0) next[j-1] += current[j];
              if (j < 140) next[j+1] += current[j];
          } else {
              next[j] += current[j]; // propagate downward
          }
      }
      System.arraycopy(next, 0, current, 0, 141);
  }
  for(int i = 0; i < current.length; i++)
    {
        total += current[i];
    }
  

      sc.close();//releases the file from your program
    return total;
    } catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return -1; //you can return from a void function just don't put a value.
    }

    }
}