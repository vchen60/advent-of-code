import java.util.*;
import java.io.*;
public class dayone {
    public static void main(String[] args) {

      System.out.println(solveA("input.txt"));
    System.out.println(solveB("input.txt"));

    }


    public static int solveA(String filename) {
      int total = 0;
      try {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        ArrayList xList = new ArrayList<String>();
        ArrayList yList = new ArrayList<String>();
        
      //CODE THAT SCANS THE FILE.
      int heading = 50;
      while(sc.hasNext()) {
        String a = sc.next();
        char direction = a.charAt(0);
        if(direction=='R') {
          heading += Integer.parseInt(a.substring(1));
        }
        else {
          heading -= Integer.parseInt(a.substring(1));
        }
        heading %= 100;
        if(heading == 0) {
          total++;
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
    


    public static int solveB(String filename) {
int total = 0;
      try {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
      //CODE THAT SCANS THE FILE.
      int heading = 0;
      int current = 50;


      while(sc.hasNext()) {
      String a = sc.next();
      char direction = a.charAt(0);
      int rot = Integer.parseInt(a.substring(1));
      if (direction == 'L') {
        for (int i = 1; i <= rot; i++) {
            current--;
            if (current < 0) current = 99;
            if (current == 0) total++;
        }
    } else { // 'R'
        for (int i = 1; i <= rot; i++) {
            current++;
            if (current > 99) current = 0;
            if (current == 0) total++;
        }
    }
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