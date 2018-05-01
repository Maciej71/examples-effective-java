package avoid_unnecessary_objects;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
public class JmhBenchmark {
  @Benchmark
  @Fork(1)
  public static void executionTimeExpensive() {
    IntStream.range(1, 100001)
        .forEach(
            c -> ExpensiveObjects.expensiveUrlCheck("https://en.wikipedia.org/wiki/Joshua_Bloch"));
  }

  @Benchmark
  @Fork(1)
  public static void executionTimeModerate() {
    IntStream.range(1, 100001)
        .forEach(
            c -> ExpensiveObjects.moderateUrlCheck("https://en.wikipedia.org/wiki/Joshua_Bloch"));
  }
}
