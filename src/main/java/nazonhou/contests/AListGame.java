package nazonhou.contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AListGame {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int maximumValueOfX = 10_000_000;

    List<Integer> primes = new ArrayList<Integer>(maximumValueOfX - 1);

    for (int iteration = 2; iteration <= maximumValueOfX / 2; iteration++) {
      // System.out.println(iteration);
      primes.add(iteration);
    }

    int iteration = 0;

    while (iteration < primes.size()) {
      int prime = primes.get(iteration);

      for (int primeMultiple = 2 * prime; primeMultiple <= primes
          .get(primes.size() - 1); primeMultiple += prime) {
        if (primes.contains(primeMultiple)) {
          primes.remove(primes.indexOf(primeMultiple));
        }
      }
      iteration++;
    }

    while (input.hasNextInt()) {
      int X = input.nextInt();
      int K = 0;
      iteration = 0;

      while (X > primes.get(iteration)) {
        if (X % primes.get(iteration) == 0) {
          X /= primes.get(iteration);
          K++;
        }
        iteration++;
      }

      System.out.println(K);
    }

    input.close();
  }
}
