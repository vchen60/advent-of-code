import java.util.*;
import java.io.*;
public class dayfour {
    public static void main(String[] args) {

      System.out.println(solve("input.txt"));
      System.out.println(solvePart2("input.txt"));

    }

    public static int solve(String filename) {
int total = 0;
      try {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
      //CODE THAT SCANS THE FILE.
      char[][] table = new char[135][135];
      int idx = 0;

      while(sc.hasNextLine()) {
        
      String a = sc.nextLine();
      for(int i = 0; i < 135; i++) {
        table[idx][i]=a.charAt(i);
      }
      idx++;
  }
  for(int i = 0; i < 135; i++) {
    for(int j = 0; j < 135; j++) {
        if(table[i][j]=='@') {
            int checker = 0;int[] dx = {-1,-1,-1, 0,0, 1,1,1};
            int[] dy = {-1, 0, 1,-1,1,-1,0,1};
            
            for (int k = 0; k < 8; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx >= 0 && nx < 135 && ny >= 0 && ny < 135) {
                    if (table[nx][ny] == '@') checker++;
                }
            }
            if (checker < 4) total++;
            
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

    public static int solvePart2(String filename) {
    try {
        Scanner sc = new Scanner(new File(filename));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) lines.add(sc.nextLine());
        sc.close();

        int rows = lines.size();
        int cols = lines.get(0).length();

        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = lines.get(i).toCharArray();
        }

        int totalRemoved = 0;
        boolean changed = true;

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        while (changed) {
            changed = false;
            boolean[][] toRemove = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '@') {
                        int neighbors = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                                if (grid[nx][ny] == '@') neighbors++;
                            }
                        }
                        if (neighbors < 4) {
                            toRemove[i][j] = true;
                        }
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (toRemove[i][j]) {
                        grid[i][j] = '.';
                        totalRemoved++;
                        changed = true;
                    }
                }
            }
        }
        return totalRemoved;

    } catch (FileNotFoundException e) {
        System.out.println("File not found");
        return -1;
    }
}


}