package singleton;

public class StaticFactory {
  private static final StaticFactory INSTANCE = new StaticFactory();

  private StaticFactory() {}

  public static StaticFactory getInstance() {
    return INSTANCE;
  }
}
