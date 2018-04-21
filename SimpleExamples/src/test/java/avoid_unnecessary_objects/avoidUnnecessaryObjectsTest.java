package avoid_unnecessary_objects;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class avoidUnnecessaryObjectsTest {

  @Test
  public void immutableTest() {
    List namesImmutable = new Immutable().get();
    List<String> namesMutable = Arrays.asList("a", "c", "d", "b", "f", "g", "h");
    List<String> sortedList = Arrays.asList("a", "b", "c", "d", "f", "g", "h");

    namesMutable.sort(Comparator.naturalOrder());
    assertEquals(sortedList, namesMutable);

    try {
      namesImmutable.sort(Comparator.naturalOrder());
      fail();
    } catch (UnsupportedOperationException e) {
      assertTrue(true);
    }
  }

  @Test
  public void preferStaticFactoryTest() {

    List<PreferStaticFactory> generatedWithConstructor =
        IntStream.range(1, 5)
            .mapToObj(i -> new PreferStaticFactory())
            .collect(Collectors.toList());

    List<PreferStaticFactory> generatedWithFactory =
        IntStream.range(1, 5)
            .mapToObj(i -> PreferStaticFactory.getInstance())
            .collect(Collectors.toList());

    long numberOfObjectFromConstructor =
        generatedWithConstructor
            .stream()
            .filter(l -> generatedWithConstructor.stream().filter(e -> e == l).count() == 1)
            .count();

    long numberOfObjectFromFactory =
        generatedWithFactory
            .stream()
            .filter(l -> generatedWithFactory.stream().filter(e -> e == l).count() == 1)
            .count();

    Assert.assertEquals(4, numberOfObjectFromConstructor);
    Assert.assertEquals(0, numberOfObjectFromFactory);
  }
}
