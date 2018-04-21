package avoid_unnecessary_objects;

public final class PreferStaticFactory {

  private final static PreferStaticFactory INSTANCE = new PreferStaticFactory();

  public static PreferStaticFactory getInstance() {
    return INSTANCE;
  }


}
