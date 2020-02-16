package static_factory;

public class InstanceFactory {
  private static InstanceFactory instance = null;

  private InstanceFactory() {}

  public static InstanceFactory getSingletonInstance() {
    if (instance == null) {
      instance = new InstanceFactory();
      return instance;
    }

    return instance;
  }

  public static InstanceFactory getNewObject() {
    return new InstanceFactory();
  }
}
