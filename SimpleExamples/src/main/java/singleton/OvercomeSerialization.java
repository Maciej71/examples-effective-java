package singleton;

import java.io.Serializable;

public class OvercomeSerialization implements Serializable {
  private static final OvercomeSerialization INSTANCE = new OvercomeSerialization();

  private OvercomeSerialization() {}

  public static OvercomeSerialization getInstance() {
    return INSTANCE;
  }

  protected Object readResolve() {
    return INSTANCE;
  }
}
