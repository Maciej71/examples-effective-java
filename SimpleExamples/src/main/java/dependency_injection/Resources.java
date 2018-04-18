package dependency_injection;

public class Resources {
  private static final Resources INSTANCE = new Resources();

  private Resources() {}

  public static Resources getInstance() {
    return INSTANCE;
  }

  public String name() {
    return "Maciek";
  }
}
