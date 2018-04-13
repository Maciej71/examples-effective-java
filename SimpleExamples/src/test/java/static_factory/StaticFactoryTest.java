package static_factory;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class StaticFactoryTest {

  @Test
  public void simpleTest() {
    assertTrue(Simple.valueOf(true));
  }

  @Test
  public void itHasNameTest() {
    assertEquals("HashSet", ItHasName.nameOf(new HashSet()));
  }

  @Test
  public void createWhenYouWantTest() {
    assertNotSame(new Integer(1), new Integer(1));
    assertFalse(new Integer(1) == new Integer(1));

    assertSame(CreateWhenYouWant.valueOf(1), CreateWhenYouWant.valueOf(1));
    assertTrue(CreateWhenYouWant.valueOf(1) == CreateWhenYouWant.valueOf(1));

    assertNotSame(CreateWhenYouWant.valueOf(1), CreateWhenYouWant.valueOf(2));
    assertFalse(CreateWhenYouWant.valueOf(1) == CreateWhenYouWant.valueOf(2));
  }

  @Test
  public void returnSubtype() {
    assertEquals(Arrays.asList(1, 1, 2, 2), ReturnSubtype.returnSuitableType(1, 1, 2, 2).value());
    assertEquals(
        new HashSet<>(Arrays.asList(1, 2)), ReturnSubtype.returnSuitableType(1, 2).value());
  }

  @Test
  public void returnObjectCanVary() {
    assertEquals(
        "java.util.JumboEnumSet", ReturnObjectCanVary.valueOf(false).getClass().getCanonicalName());
    assertEquals(
        "java.util.RegularEnumSet",
        ReturnObjectCanVary.valueOf(true).getClass().getCanonicalName());
  }
}
