package noninstantiability;

public class PrivateConstructor {
  //Suppress default constructor for noninstantiability
  private PrivateConstructor() {
    throw new AssertionError();
  }

}
