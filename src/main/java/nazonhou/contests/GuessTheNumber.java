package nazonhou.contests;

import java.util.Scanner;

public class GuessTheNumber {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int MIN = 1;
    int MAX = 1000;
    int numberGuessed = 0;
    String response = "";
    int attempts = 0;

    while (!response.equals("correct") && attempts <= 10) {
      if (response.equals("lower")) {
        MAX = --numberGuessed;
      } else if (response.equals("higher")) {
        MIN = ++numberGuessed;
      }
      numberGuessed = (MIN + MAX) / 2;
      System.out.println(numberGuessed);
      attempts++;
      response = input.nextLine();
    }

    input.close();
  }
}
