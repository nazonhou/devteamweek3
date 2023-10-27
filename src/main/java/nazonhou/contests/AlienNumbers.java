package nazonhou.contests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlienNumbers {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int T = input.nextInt();

    for (int testCase = 1; testCase <= T; testCase++) {
      char[] alienNumberDigits = input.next().toCharArray();

      char[] sourceBaseDigits = input.next().toCharArray();
      Map<Character, Integer> mappingSourceBaseDigits = new HashMap<Character, Integer>();
      for (int iteration = 0; iteration < sourceBaseDigits.length; iteration++) {
        mappingSourceBaseDigits.put(sourceBaseDigits[iteration], iteration);
      }
      int alienNumber = 0;

      for (int iteration = alienNumberDigits.length - 1; iteration >= 0; iteration--) {
        alienNumber += mappingSourceBaseDigits.get(alienNumberDigits[iteration])
            * Math.pow(sourceBaseDigits.length, alienNumberDigits.length - 1 - iteration);
      }

      char[] targetBaseDigits = input.next().toCharArray();
      int targetBase = targetBaseDigits.length;
      String alienNumberInTargetBase = "";

      while (alienNumber >= targetBaseDigits.length) {
        alienNumberInTargetBase = targetBaseDigits[alienNumber % targetBase] + alienNumberInTargetBase;
        alienNumber /= targetBase;
      }

      alienNumberInTargetBase = targetBaseDigits[alienNumber] + alienNumberInTargetBase;

      System.out.println("Case #" + testCase + ": " + alienNumberInTargetBase);
    }

    input.close();
  }
}
