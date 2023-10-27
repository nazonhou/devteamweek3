package nazonhou.contests;

import java.util.Scanner;

public class AListGame {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    while (input.hasNextInt()) {
      int X = input.nextInt();
      int K = 0;

      int primeFactor = 2;

      while (primeFactor * primeFactor <= X) {
        while (X % primeFactor == 0) {
          K++;
          X /= primeFactor;
        }
        primeFactor += primeFactor == 2 ? 1 : 2;
      }

      if (X > 2) {
        K++;
      }

      System.out.println(K);
    }

    input.close();
  }
}
