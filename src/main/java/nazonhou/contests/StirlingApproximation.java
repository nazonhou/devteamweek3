package nazonhou.contests;

import java.util.Scanner;

public class StirlingApproximation {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[] factorialNapierianLogarithms = new double[100001];

    for (int iteration = 1; iteration < factorialNapierianLogarithms.length; iteration++) {
      factorialNapierianLogarithms[iteration] = factorialNapierianLogarithms[iteration - 1] + Math.log(iteration);
    }

    int n = input.nextInt();

    do {
      double stirlingApproximationNapierianLogarithm = (Math.log(2 * Math.PI) / 2)
          + (Math.log(n) / 2) + (n * Math.log(n)) - n;

      double approximation = Math.exp(factorialNapierianLogarithms[n] - stirlingApproximationNapierianLogarithm);

      System.out.println(approximation);

      n = input.nextInt();
    } while (n != 0);

    input.close();
  }
}
