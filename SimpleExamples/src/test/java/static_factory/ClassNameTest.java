package static_factory;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class ClassNameTest {

  @Test
  public void from_Should_ReturnNameOfObjectClass() {
    assertEquals("HashSet", ClassName.from(new HashSet()));
    assertEquals("LinkedList", ClassName.from(new LinkedList<>()));
  }
}
