package singleton;

import java.io.Serializable;

public class SerializationFlaw implements Serializable {
  public static final SerializationFlaw INSTANCE = new SerializationFlaw();
  private SerializationFlaw() {}

  public static SerializationFlaw getInstance() {
    return INSTANCE;
  }
}
