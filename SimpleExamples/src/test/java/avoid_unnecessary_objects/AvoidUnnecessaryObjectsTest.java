package avoid_unnecessary_objects;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class AvoidUnnecessaryObjectsTest {

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
        IntStream.range(1, 5).mapToObj(i -> new PreferStaticFactory()).collect(Collectors.toList());

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

  @Test
  public void expansiveObjectsTest() throws RunnerException {
    Options opt = new OptionsBuilder().include(JmhBenchmark.class.getSimpleName()).build();
    Collection<RunResult> runResults = new Runner(opt).run();

    assertTrue(
        Iterables.get(runResults, 0).getPrimaryResult().getScore()
            > Iterables.get(runResults, 1).getPrimaryResult().getScore());
  }

  @Test
  public void adapterTest() {
    Adapter adapter = new Adapter();
    Set beforeHeroAdd = adapter.getKeys();
    int beforeSize = beforeHeroAdd.size();

    assertSame(adapter.getKeys(), adapter.getKeys());

    adapter.addHero();
    Set afterHeroAdd = adapter.getKeys();
    int afterSize = afterHeroAdd.size();

    assertSame(adapter.getKeys(), adapter.getKeys());

    assertSame(beforeHeroAdd, afterHeroAdd);
    assertNotEquals(beforeSize, afterSize);
  }
}
