package nazonhou.contests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class StirlingApproximationTest {
  @Test
  public void sampleInput1() {
    assertTrue(
        isApproximationGood("1.084437551419227546611577313", "1.0844375514192277", "0.00000001"));
  }

  @Test
  public void sampleInput10() {
    assertTrue(
        isApproximationGood("1.008365359132400245905553271", "1.0083653591323987", "0.00000001"));
  }

  @Test
  public void sampleInput150() {
    assertTrue(
        isApproximationGood("1.000555709081632955425046604", "1.00055570908184", "0.00000001"));
  }

  public boolean isApproximationGood(String exact, String actual, String absoluteError) {
    BigDecimal leftLimit = new BigDecimal(exact).subtract(new BigDecimal(absoluteError));
    BigDecimal rightLimit = new BigDecimal(exact).add(new BigDecimal(absoluteError));
    BigDecimal approximation = new BigDecimal(actual);

    return leftLimit.compareTo(approximation) == -1
        || rightLimit
            .compareTo(approximation) == 1;
  }
}
