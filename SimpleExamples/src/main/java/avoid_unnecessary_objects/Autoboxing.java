package avoid_unnecessary_objects;

public class Autoboxing {
  private static final int START = 0;
  private static final int STOP = 10000000;

  public static void sumPrimitive() {
    long sum = 0L;
    for (long i = START; i < STOP; i++) {
      sum += i;
    }
  }

  public static void sumAutoBoxed() {
    Long sum = 0L;
    for (long i = START; i < STOP; i++) {
      sum += i;
    }
  }
}
