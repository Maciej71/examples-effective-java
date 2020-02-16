package static_factory;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StaticFactoryTest {

  @Test
  public void simpleTest() {
    assertTrue(Simple.valueOf(true));
  }

  @Test
  public void returnSubtype() {
    assertEquals(Arrays.asList(1, 1, 2, 2), ReturnSubtype.returnSuitableType(1, 1, 2, 2).value());
    assertEquals(
        new HashSet<>(Arrays.asList(1, 2)), ReturnSubtype.returnSuitableType(1, 2).value());
  }

}
