package avoid_unnecessary_objects;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

@BenchmarkMode(Mode.AverageTime)
public class JmhAutobixing {
  @Benchmark
  @Fork(1)
  public static void executionTimePrimitive() {
    Autoboxing.sumPrimitive();
  }

  @Benchmark
  @Fork(1)
  public static void executionTimeAutoboxed() {
    Autoboxing.sumAutoBoxed();
  }
}
